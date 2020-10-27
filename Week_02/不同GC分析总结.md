1. 使用GCLogAnalysis.java 自己演练一遍串行/并行/CMS/G1的案例；
   
   - 当堆内存设置过小，不管使用何种GC配置都会容易出现outofmemory，Full GC次数比较频繁，因此设置合适的初始堆大小，默认建议设置机器内存的1/4
   
     java -XX:+UseSerialGC -Xms128m -Xmx128m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
   
     ![image-20201027230942546](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201027230942546.png)
   
     java -XX:+UseParallelGC -Xms128m -Xmx128m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
   
     ![image-20201027231000793](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201027231000793.png)
   
     java -XX:+UseConcMarkSweepGC -Xms128m -Xmx128m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
   
     ![image-20201027231023386](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201027231023386.png)
   
     java -XX:+UseG1GC -Xms128m -Xmx128m -XX:+PrintGC -XX:+PrintGCDateStamps GCLogAnalysis
   
     ![image-20201027231048517](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201027231048517.png)
   
   - 同一GC配置，随着对内存增加，GC次数减少，降低发生OOM的概率，但随着内存增大到一定程度，系统处理能力不会有显著增加，例如生成对象的次数不再成倍增加。使用串行GC,堆内存分别从256M,512M,1024M,1280M,1536M,1664M; 256M到1536M,生成对象次数在逐步递增，但是到1664M后没有增加，反而有小范围下降。
   
     ![image-20201027232519179](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201027232519179.png)
   
     ![image-20201027232548511](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201027232548511.png)
   
     ![image-20201027232618666](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201027232618666.png)
   
     ![image-20201027232636291](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201027232636291.png)
   
     ![image-20201027232700588](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201027232700588.png)
   
   - 并行GC下，如果不指定-Xms，GC次数会提前
   
     指定-Xms为256M.65M时，做了一次YongGC
   
     ![image-20201027234343899](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201027234343899.png)
   
     不指定-Xms，4M时就做了一次YongGC
   
     ![image-20201027234452986](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201027234452986.png)
   
   - 初始堆内存和最大堆内存为512M，比较并行GC, CMSGC和G1GC生成的对象次数差不多，并行GC，在一次FullGC后，年轻代可以全部回收
   
     ![image-20201028000433515](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201028000433515.png)
   
     ![image-20201028000530539](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201028000530539.png)
   
     ![image-20201028000602479](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201028000602479.png)
   
2. 使用压测工具（wrk或sb），演练gateway-server-0.0.1-SNAPSHOT.jar 示例

   不同GC配置，相同并发，20个并发持续时间30秒

   - 串行GC,RPS:1693

     java -jar -XX:+UseSerialGC gateway-server-0.0.1-SNAPSHOT.jar

     ![image-20201028001233122](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201028001233122.png)

   - 并行GC

     java -jar -XX:+UseParallelGC gateway-server-0.0.1-SNAPSHOT.jar

     ![image-20201028001446707](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201028001446707.png)

   - CMSGC

     java -jar -XX:+UseConcMarkSweepGC gateway-server-0.0.1-SNAPSHOT.jar

     ![image-20201028001610204](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201028001610204.png)

   - G1GC

     java -jar -XX:+UseG1GC gateway-server-0.0.1-SNAPSHOT.jar

     ![image-20201028001755370](C:\Users\liang\AppData\Roaming\Typora\typora-user-images\image-20201028001755370.png)

     总结：并行GC配置RPS最高，串行GC配置RPS最低，并行GC，CMSGC和G1GC平均时间差不多




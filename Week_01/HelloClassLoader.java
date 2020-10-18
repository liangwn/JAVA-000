package com.jerry.learn;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * Created by liang on 2020/10/18.
 */
public class HelloClassLoader extends ClassLoader {


    public static void main(String[] args) {

        try {
            Object obj = new HelloClassLoader().findClass("Hello").newInstance();
            Method method = obj.getClass().getMethod("hello");
            method.invoke(obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        InputStream inputStream = null;
        try {
            URL url = this.getClass().getClassLoader().getResource("Hello.xlass");
            inputStream = url.openStream();
            int a;
            byte[] array = new byte[inputStream.available()];
            int i=0;
            while ((a = inputStream.read()) != -1) {
                array[i++] = (byte) (255 - a);
            }
            return defineClass(name, array, 0, array.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;

    }

}

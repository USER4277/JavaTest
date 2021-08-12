/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jessetest.test;
import com.jessetest.classes.ThreadDemo;
import com.jessetest.Enums.*;
import java.util.*;
import com.jessetest.classes.*;
import java.io.*;
/**
 *
 * @author I540371
 */
public class Test1 {

    // 执行输出结果
    public static void main(String[] args)
    {       
        testMulRunable();
    } 
    
    public static void testMulRunable(){
      RunnableDemo T1 = new RunnableDemo( "Thread-1");
      T1.start();
      
      RunnableDemo T2 = new RunnableDemo( "Thread-2");
      T2.start();
    }
    
    public static void testMulThread(){
      ThreadDemo T1 = new ThreadDemo( "Thread-1");
      T1.start();
      
      ThreadDemo T2 = new ThreadDemo( "Thread-2");
      T2.start();
    
    }
    
    public static void testSocket(){
        
        String port = "6067";
        String[] args = {port};
         try{
            SocketServer1 sS1 = new SocketServer1(6067);
            SocketClient sC1 = new SocketClient("Localhost",6067);
            sC1.connectServer();
            sS1.serviceStart();
            
            sC1.doAction();
            sC1.doAction();
            sS1.serviceEnd();
         }catch(IOException e)
      {
         e.printStackTrace();
      }
    }

    
    public static void testDeserialize(){
        GenericClassTmp1<String> gCT2 = null;
         try
            {
               FileInputStream fileIn = new FileInputStream("C:/Users/I540371/Documents/NetBeansProjects/TEST1/gCT1.ser");
               ObjectInputStream in = new ObjectInputStream(fileIn);
               gCT2 = (GenericClassTmp1<String>) in.readObject();
               in.close();
               fileIn.close();
            }catch(IOException i)
            {
               i.printStackTrace();
               return;
            }catch(ClassNotFoundException c)
            {
               System.out.println("GenericClassTmp1 class not found");
               c.printStackTrace();
               return;
            }
    }
    
    public static void testSerialization(){
        GenericClassTmp1<String> gCT1 = new GenericClassTmp1("T1");
        try{
            FileOutputStream fileOut = new FileOutputStream("C:/Users/I540371/Documents/NetBeansProjects/TEST1/gCT1.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gCT1);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in C:/Users/I540371/Documents/NetBeansProjects/TEST1/gCT1.ser");
        }catch(IOException i){
            i.printStackTrace();
        }
    }
    
    public static void test12(){
        GenericClassTmp1<String> gClassTmp1 = new GenericClassTmp1("1");
        GenericFriut gFriut = new GenericFriut();
        GenericTest1<GenericClassTmp1> gTest1 = new GenericTest1<GenericClassTmp1>();
        
        gTest1.show_1(gClassTmp1);
        gTest1.show_2(gFriut);
        gTest1.show_2(gClassTmp1);
        gTest1.show_3(gFriut);
        gTest1.show_3(gClassTmp1);
    }
    
    
    public static void test14(){
        
        GenericClassTmp1 gCT1 = new GenericClassTmp1<String>("str1");
        GenericClassTmp1 gCT2 = new GenericClassTmp1<Integer>(22);
        showKey( gCT1 );
        showKey( gCT2 );
    }
    
    public static void showKey(GenericClassTmp1<?> genObj){
        System.out.println( genObj.getKey() );
    }
    
    public static void test10(){
        
        GenericClassTmp1 gCT1 = new GenericClassTmp1<String>("str1");
        GenericClassTmp1 gCT2 = new GenericClassTmp1<Integer>(22);
        System.out.println( gCT1.getKey() );
        System.out.println( gCT2.getKey() );
    }
    
    public static void test9(){
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        
        GenericMethodTest gT = new GenericMethodTest();
        
        System.out.println( "整型数组元素为:" );
        gT.printArray( intArray  ); // 传递一个整型数组
 
        System.out.println( "\n双精度型数组元素为:" );
        gT.printArray( doubleArray ); // 传递一个双精度型数组
 
        System.out.println( "\n字符型数组元素为:" );
        gT.printArray( charArray ); // 传递一个字符型数组
    }
    
    public static void test5(){
        ArrayList aL =  new ArrayList<String>();
        aL.add("1111");
        aL.add("1112");
        aL.add("1113");
        aL.add("1114");
        
        Iterator it1 = aL.iterator();
        while (it1.hasNext()){
            System.out.println(it1.next().toString());
        }
    }
    
    public static void test4(){
        HashMap<Integer, String> Sites = new HashMap<Integer, String>();
        // 添加键值对
        Sites.put(1, "Google");
        Sites.put(2, "Runoob");
        Sites.put(3, "Taobao");
        Sites.put(4, "Zhihu");
        System.out.println(Sites);
        
        for(Integer i: Sites.keySet()){
            System.out.println(i);
        }
        
        for(String i: Sites.values()){
            System.out.println(i);
        }
        
    }
    
    public static void test7(){
        HashSet<String> sites = new HashSet<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");
        sites.add("Runoob");  // 重复的元素不会被添加
        System.out.println(sites);
        System.out.println(sites.contains("Zhihu"));
        sites.clear();
        System.out.println(sites);
    }
    
    public static void test6(){
        LinkedList<String> LL1 = new LinkedList<String>();
        LL1.add("Jesse");
        LL1.add("KKJHGG");
        LL1.add("lkjjh");
        LL1.add("Ljdghh");
        LL1.addFirst("Fisrt");
        LL1.addLast("Last");
        System.out.println(LL1);
        LL1.removeFirst();
        LL1.removeLast();
        System.out.println(LL1);
        System.out.println(LL1.getFirst());
        
        for(int i = 0; i < LL1.size(); i++){
            System.out.println(LL1.get(i));
        }
        for(String i: LL1){
            System.out.println(i);
        }
    }
    
    public static void test3(){
     ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        sites.remove(2);
        sites.set(2,"Jesse");
        System.out.println(sites.get(2));
        System.out.println(sites.size());
        Collections.sort(sites);
        for (String i: sites){
            System.out.println(i);
        }
    }
    
    public static void test1(){
     List<String> list=new ArrayList<String>();
     list.add("Hello");
     list.add("World");
     list.add("HAHAHAHA");
     
     Iterator<String> ite = list.iterator();
     while(ite.hasNext()){//判断下一个元素之后有值
         System.out.println(ite.next());
     };
    }
    
    public static void test2(){
     Map<String, String> map = new HashMap<String, String>();
      map.put("1", "value1");
      map.put("2", "value2");
      map.put("3", "value3");
      
       //第一种：普遍使用，二次取值
      System.out.println("通过Map.keySet遍历key和value：");
      for (String key : map.keySet()) {
       System.out.println("key= "+ key + " and value= " + map.get(key));
      }
      
      //第二种
      System.out.println("通过Map.entrySet使用iterator遍历key和value：");
      Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
      while (it.hasNext()) {
       Map.Entry<String, String> entry = it.next();
       System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
      }
      
      //第三种：推荐，尤其是容量大时
      System.out.println("通过Map.entrySet遍历key和value");
      for (Map.Entry<String, String> entry : map.entrySet()) {
       System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
      }
    
      //第四种
      System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
      for (String v : map.values()) {
       System.out.println("value= " + v);
      }
    }
}

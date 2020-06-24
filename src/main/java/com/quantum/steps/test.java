package com.quantum.steps;

import com.google.common.io.FileBackedOutputStream;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.quantum.thsPageObj.petDogBean;
import cucumber.api.java.it.Ma;
import io.appium.java_client.android.AndroidDriver;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class test {

    public static Iterator gettag(Iterator it)
    {
        Iterator iterator=null;
        while(it.hasNext())
        {
            Element element= (Element) it.next();
//            System.out.println(element.getName());
            String tagName=element.getName();
//            element.setAttributeValue("modelVersion","21");
//            System.out.println(element.getNamespace().getURI());
            System.out.println(element.getQName("xmlns:xsi").getNamespaceURI());
            System.out.println(element.getNamespacePrefix());
            Map map=new HashMap();
            map.put("ads","wwsda");
            DocumentFactory documentFactory=new DocumentFactory();
            documentFactory.setXPathNamespaceURIs(map);
            System.out.println(element.getQName("xsi").getNamespaceURI());
            System.out.println(element.getQName("schemaLocation").getNamespaceURI());
            iterator =element.elementIterator();
        }
        return iterator;
    }
    public static void writeFile(Document doc,String path){
        OutputFormat outputFormat=OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("utf-8");
        try {
            XMLWriter xmlWriter=new XMLWriter(new OutputStreamWriter(new FileOutputStream(path),"utf-8"),outputFormat);
            xmlWriter.setEscapeText(false);
            xmlWriter.write(doc);
            xmlWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void testReadXml()
    {
        String path="C:\\Users\\wjd\\Desktop\\Quantum-Starter-Kit-master\\resources\\pom.xml";
        SAXReader saxReader=new SAXReader();
        try {
            Document document=saxReader.read(path);
            Map map=new HashMap();
            map.put("abc","http://www.jksd.com");
            map.put("ab1c","http://www.jkssdd.com");
            saxReader.getDocumentFactory().setXPathNamespaceURIs(map);
            Element root=document.getRootElement();
            System.out.println(root.getNamespaceForPrefix("xsi").getURI());
            document.getRootElement().getNamespace().getURI();
            Iterator it=root.elementIterator();
            Iterator iterator=gettag(it);
            gettag(iterator);
            writeFile(document,path);
        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }
    public static void getRequest(){
        petDogBean pet=new petDogBean();
        pet.setId(1);
        pet.setUsername("xfang");
        pet.setFirstName("x");
        pet.setLastName("fang");
        pet.setEmail("12312312");
        pet.setPassword("123123");
        pet.setPhone("12312312");
        pet.setUserStatus("000");
        Gson gson=new Gson();
        gson.toJson(pet);
        Response response= given().contentType("application/json")
                .body(pet)
                .when()
                .post("https://petstore.swagger.io/v2/user");
        response.then().assertThat().statusCode(200);
        System.out.println("Add------------------->"+response.body().toString());
    }
    public static void queryUser(){
        String Url="https://petstore.swagger.io/v2/user/username";
//        RestAssured.baseURI="https://petstore.swagger.io/v2";
        Response response1=given().pathParams(Url,"xfang")
                .when().get(Url);
        System.out.println("--------ssss------"+response1.statusCode());
        System.out.println("--------------"+response1.body().prettyPrint());
    }

    public static void deleteUser(){
        Response response1=given().contentType("application/json").when().delete("https://petstore.swagger.io/v2/user/xfang");
        response1.then().assertThat().statusCode(200);
        System.out.println("delete------>statue-----"+response1.statusCode());
        System.out.println("delete------>"+response1.body().toString());
    }
    public static void updateUser(){
        petDogBean pet=new petDogBean();
        pet.setId(2);
        System.out.println("id---1------>"+pet.getId());
        pet.setUsername("xfang");
        pet.setFirstName("x");
        pet.setLastName("fang");
        pet.setEmail("12312312@qq.com");
        pet.setPassword("123123");
        pet.setPhone("12312312");
        pet.setUserStatus("000111");
        Gson gson=new Gson();
        gson.toJson(pet);
        Response response1=given().contentType("application/json").body(pet).when().put("https://petstore.swagger.io/v2/user/xfang");
        response1.then().assertThat().statusCode(200);
        System.out.println("updateUser------>"+response1.body().print());
    }
    public static void main(String[] args) {
        getRequest();
        queryUser();
        updateUser();
        queryUser();
        deleteUser();
        queryUser();
    }

}

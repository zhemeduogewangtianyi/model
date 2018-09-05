package com.oak.model;

import com.oak.model.entity.picture.PicturePO;
import com.oak.model.util.JdbcUtils;

import javax.persistence.Table;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJdbc {
    public static void main(String[] args){

//        List<TestVO> result = getTest();
//        for(TestVO vo : result){
//            System.out.println(vo.getId());
//            System.out.println(vo.getParentId());
//            System.out.println(vo.getCategory());
//            System.out.println(vo.getAddSelect());
//            System.out.println(vo.getErrorInfo());
//            System.out.println(vo.getState());
//            System.out.println(vo.getUpdateTime());
//            System.out.println(vo.getUpdateStr());
//            System.out.println(vo.getUpdateName());
//        }

//        Map<String,Object> object = getObject(PicturePO.class);
        List<Map<String,Object>> select = selectAll(PicturePO.class);
        System.out.println(select);

    }

    /**
     * 使用方法：在PO实体类（与数据库对应的实体类）加上@Table注解，name属性对应表，例如 @Table(name = "test")
     * 本查询方法只需要给出PO实体的class即可 例如 selectAll(testPO.class)
     *
     * 作者 ： 王天一和他的天下第一好们
     * 日期 ： new Date()
     *
     * **/

    public static List<Map<String, Object>> selectAll(Class clazz){
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        Map<String,Object> map = getObject(clazz);
        List<String> properties = (List<String>) map.get("properties");

        Map<String,Object> resultMap = new HashMap<>();

        String sql = "select * from "+map.get("table");
        try{
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery(sql);
            List<Map<String,Object>> list = new ArrayList<>();

            while(result.next()){
                for(int i = 0 ; i < properties.size() ; i++){
                    String[] arr = properties.get(i).split("&");
                    Integer index = i+1;
                    if(arr[1].contains("Byte") || arr[1].contains("byte")){
                        resultMap.put(arr[0],result.getByte(index));
                        continue;
                    }
                    if(arr[1].contains("Short") || arr[1].contains("short")){
                        resultMap.put(arr[0],result.getShort(index));
                        continue;
                    }
                    if(arr[1].contains("Integer") || arr[1].contains("int")){
                        resultMap.put(arr[0],result.getInt(index));
                        continue;
                    }
                    if(arr[1].contains("Long") || arr[1].contains("long")){
                        resultMap.put(arr[0],result.getLong(index));
                        continue;
                    }
                    if(arr[1].contains("Boolean") || arr[1].contains("boolean")){
                        resultMap.put(arr[0],result.getBoolean(index));
                        continue;
                    }
                    if(arr[1].contains("Double") || arr[1].contains("double")){
                        resultMap.put(arr[0],result.getDouble(index));
                        continue;
                    }
                    if(arr[1].contains("Float") || arr[1].contains("float")){
                        resultMap.put(arr[0],result.getFloat(index));
                        continue;
                    }
                    if(arr[1].contains("Date") || arr[1].contains("date")){
                        resultMap.put(arr[0],result.getDate(index));
                        continue;
                    }
                    if(arr[1].contains("String") || arr[1].contains("Char") || arr[1].contains("char")){
                        resultMap.put(arr[0],result.getString(index));
                        continue;
                    }
                }
//                Long id = result.getLong(1);
//                Long parentId = result.getLong(2);
//                String category = result.getString(3);
//                String addSelect = result.getString(4);
//                String errorInfo = result.getString(5);
//                Integer state = result.getInt(6);
//                Date updateTime = result.getDate(7);
//                String updateName = result.getString(8);
//                TestVO vo = new TestVO();
//                vo.setId(id);
//                vo.setParentId(parentId);
//                vo.setCategory(category);
//                vo.setAddSelect(addSelect);
//                vo.setErrorInfo(errorInfo);
//                vo.setState(state);
//                vo.setUpdateTime(updateTime);
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                vo.setUpdateStr(sdf.format(updateTime));
//                vo.setUpdateName(updateName);
                list.add(resultMap);

            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally {
            JdbcUtils.close(connection,preparedStatement,result);
        }
        return null;
    }

    public static Map<String,Object> getObject(Class clazzPO){
        Map<String,Object> map = new HashMap<>();
        try{
            String name = clazzPO.getName();

            Class<?> aClass = Class.forName(name);
            map.put("name",name);
            map.put("po",aClass.newInstance());
            map.put("table",aClass.getAnnotation(Table.class).name());

            List<String> list = new ArrayList<>();
            Field[] declaredFields = clazzPO.getDeclaredFields();
            for(Field field : declaredFields){
                list.add(field.getName() + "&" + field.getGenericType().getTypeName());
            }
            map.put("properties",list);
            return map;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }



}

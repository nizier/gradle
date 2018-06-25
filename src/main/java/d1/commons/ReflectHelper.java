package d1.commons;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;

public class ReflectHelper {

    public static void clonePOJO(Object s,Object t) throws Exception{
        Field[] field = s.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组

        for (int j = 0; j < field.length; j++) { // 遍历所有属性
            String name = field[j].getName(); // 获取属性的名字
            name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
            String type = field[j].getGenericType().toString(); // 获取属性的类型
            if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                Method m = s.getClass().getMethod("get" + name);
                String value = (String) m.invoke(s); // 调用getter方法获取属性值
                if (value != null) {
                    m = t.getClass().getMethod("set" + name, String.class);
                    m.invoke(t, value);
                }
            }
            if (type.equals("class java.lang.Integer")) {
                Method m = s.getClass().getMethod("get" + name);
                Integer value = (Integer) m.invoke(s);
                if (value != null) {
                    m = t.getClass().getMethod("set" + name, Integer.class);
                    m.invoke(t, value);
                }
            }
            if (type.equals("class java.lang.Boolean")) {
                Method m = s.getClass().getMethod("get" + name);
                Boolean value = (Boolean) m.invoke(s);
                if (value != null) {
                    m = t.getClass().getMethod("set" + name, Boolean.class);
                    m.invoke(t, value);
                }
            }
            if (type.equals("class java.util.Date")) {
                Method m = s.getClass().getMethod("get" + name);
                Date value = (Date) m.invoke(s);
                if (value != null) {
                    m = t.getClass().getMethod("set" + name, Date.class);
                    m.invoke(t, value);
                }
            }

            if (type.equals("class java.math.BigDecimal")) {
                Method m = s.getClass().getMethod("get" + name);
                BigDecimal value = (BigDecimal) m.invoke(s);
                if (value != null) {
                    m = t.getClass().getMethod("set" + name, BigDecimal.class);
                    m.invoke(t, value);
                }
            }
            if (type.equals("class java.math.BigDecimal")) {
                Method m = s.getClass().getMethod("get" + name);
                BigDecimal value = (BigDecimal) m.invoke(s);
                if (value != null) {
                    m = t.getClass().getMethod("set" + name, BigDecimal.class);
                    m.invoke(t, value);
                }
            }
        }

    }

    public static void trim(Object s) throws Exception{
        Field[] field = s.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
        for (int j = 0; j < field.length; j++) { // 遍历所有属性
            String name = field[j].getName(); // 获取属性的名字
            name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
            String type = field[j].getGenericType().toString(); // 获取属性的类型
            if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                Method m = s.getClass().getMethod("get" + name);
                String value = (String) m.invoke(s); // 调用getter方法获取属性值
                if (value != null) {
                    m = s.getClass().getMethod("set" + name, String.class);
                    m.invoke(s, value.trim());
                }
            }
        }
    }
}

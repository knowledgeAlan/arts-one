package com.zzm.property.descriptor;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * @author zhongzuoming <zhongzuoming, 1299076979@qq.com>
 * @version v1.0
 * @Description baipao
 * @encoding UTF-8
 * @date 2019-04-25
 * @time 17:25
 * @修改记录 <pre>
 * 版本       修改人         修改时间         修改内容描述
 * --------------------------------------------------
 * <p>
 * --------------------------------------------------
 * </pre>
 */
public class Utils {


    /**
     *
     * 判断对象 属性是否为空
     */
    public   static   <T > Predicate<PropertyDescriptor> nulls(T t, Class annotationClass)  {
        return  pd -> {
            Method getterMethod = pd.getReadMethod();

            boolean result = false;
            try {
                //do not get superclass property ,so filter annotationClass
                Field field = t.getClass().getDeclaredField(pd.getName());
                field.setAccessible(true);
                if (null != field.getAnnotation(annotationClass)){
                    return (getterMethod != null && getterMethod.invoke(t) == null);
                }
                return result;

            } catch (Exception e) {
                e.printStackTrace();
                return result;
            }
        } ;
    }

    /**
     *
     * 统计对象里面为空 属性
     */
    public  static  <T> List<String> getNullPropertiesList(T t,Class annotationClass) throws Exception{
        PropertyDescriptor[] propDescArr = Introspector
                .getBeanInfo(t.getClass(), Object.class)
                .getPropertyDescriptors();
        return Arrays.stream(propDescArr)
                .filter(nulls(t,annotationClass))
                .map(PropertyDescriptor::getName)
                .collect(Collectors.toList());
    }

    /**
     *
     * 如果对象属性 注解个数等于 对象空属性 返回true
     *  其他返回false 解决问题 :导入报表 所有列多为空状态
     */
    public static  <T> Boolean objectFieldsNullEqual(T t,Class annotationClass) throws Exception {

        List<String> result = getNullPropertiesList(t,annotationClass);
        int number =0;
        for(Field field : t.getClass().getDeclaredFields()){
            Annotation annotation = field.getAnnotation(annotationClass);
            if (null != annotation){
                number ++;
            }

        }

        if (number == result.size()){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}

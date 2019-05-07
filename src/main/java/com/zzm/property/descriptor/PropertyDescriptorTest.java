package com.zzm.property.descriptor;

import javax.annotation.Resource;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhongzuoming <zhongzuoming, 1299076979@qq.com>
 * @version v1.0
 * @Description baipao
 * @encoding UTF-8
 * @date 2019-04-23
 * @time 20:32
 * @修改记录 <pre>
 * 版本       修改人         修改时间         修改内容描述
 * --------------------------------------------------
 * @link https://www.baeldung.com/java-getters-returning-null
 * <p>
 * --------------------------------------------------
 * </pre>
 */
public class PropertyDescriptorTest {
    public static void main(String[] args) throws Exception {

        //判断对象所有字段是否为空
        Customer customer = new Customer(null, null, null, null);

        System.out.println(Utils.objectFieldsNullEqual(customer, Resource.class));

    }

}

package com.zzm.property.descriptor;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @author zhongzuoming <zhongzuoming, 1299076979@qq.com>
 * @version v1.0
 * @Description baipao
 * @encoding UTF-8
 * @date 2019-04-24
 * @time 09:01
 * @修改记录 <pre>
 * 版本       修改人         修改时间         修改内容描述
 * --------------------------------------------------
 * <p>
 * --------------------------------------------------
 * </pre>
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = -1317000327017828957L;

    private Long id;
    @Resource
    private String name;

    @Resource
    private String desc;

    @Resource
    private String heigh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHeigh() {
        return heigh;
    }

    public void setHeigh(String heigh) {
        this.heigh = heigh;
    }

    public Customer(Long id, String name, String desc, String heigh) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.heigh = heigh;
    }
}

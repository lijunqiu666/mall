package whut.mall.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName District
 * @Description 全国区级以上地理信息
 * @Author liaowenhua
 * Date 2020/8/23 16:41
 **/
@Entity
@Table(name = "t_district")
public class District {
    @Id
    @GeneratedValue
    int id;
    private String parent;//父级代码
    private String code;//自己代码
    private String name;//名称


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

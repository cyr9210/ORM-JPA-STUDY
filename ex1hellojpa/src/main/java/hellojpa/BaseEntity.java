package hellojpa;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

    private String createdBy;
    private String createdDate;
    private String lastModifiedBy;
    private String lastModifiedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }
}

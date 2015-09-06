package listener;


import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.lang.reflect.Field;
import java.util.Date;

public class TimestampEntityListener {

    /***
     * digunakan untuk menyimpan tanggal ketika object di INSERT ke database
     * hanya jika terdapat field createdAt
     * kemudian isi juga field updatedAt
     */
    @PrePersist
    public void prePersist(Object o) {
        try {
            Field createdAt = o.getClass().getDeclaredField("createdAt");
            createdAt.setAccessible(true);
            createdAt.set(o, new Date());
            preUpdate(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * digunaan untuk menyimpa tanggal ketika object di UPDATE ke database
     * hanya jika terdapat field updatedAt
     * */
    @PreUpdate
    public void preUpdate(Object o) {
        try {
            Field updatedAt = o.getClass().getDeclaredField("updatedAt");
            updatedAt.setAccessible(true);
            updatedAt.set(o, new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

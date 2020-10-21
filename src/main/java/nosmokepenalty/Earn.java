package nosmokepenalty;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Earn_table")
public class Earn {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long checkInId;
    private Long point;
    private String status;

    @PostUpdate
    public void onPostUpdate(){
        Earned earned = new Earned();
        BeanUtils.copyProperties(this, earned);
        earned.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(Long checkInId) {
        this.checkInId = checkInId;
    }
    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

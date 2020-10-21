package nosmokepenalty;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Deduct_table")
public class Deduct {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long payId;
    private Long point;

    @PostPersist
    public void onPostPersist(){
        PointPaid pointPaid = new PointPaid();
        BeanUtils.copyProperties(this, pointPaid);
        pointPaid.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }
    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }




}

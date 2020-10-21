package nosmokepenalty;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Prohibit_table")
public class Prohibit {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long penaltyId;
    private Long point;

    @PostUpdate
    public void onPostUpdate(){
        Prohibited prohibited = new Prohibited();
        BeanUtils.copyProperties(this, prohibited);
        prohibited.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getPenaltyId() {
        return penaltyId;
    }

    public void setPenaltyId(Long penaltyId) {
        this.penaltyId = penaltyId;
    }
    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }




}

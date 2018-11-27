package polls;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Choice {

  @Column(length = 300)
  private String choice;

  private Integer votes;

  public Choice() {
  }

  public Choice(String choice, Integer votes) {
    this.choice = choice;
    this.votes = votes;
  }

  public String getChoice() {
    return choice;
  }

  public void setChoice(String choice) {
    this.choice = choice;
  }

  public Integer getVotes() {
    return votes;
  }

  public void setVotes(Integer votes) {
    this.votes = votes;
  }
}

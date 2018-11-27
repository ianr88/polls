package polls;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CreateQuestionRequest {

  private String question;

  private LocalDateTime publishedAt;

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public LocalDateTime getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(LocalDateTime publishedAt) {
    this.publishedAt = publishedAt;
  }

  public List<Choice> getChoices() {
    return choices;
  }

  public void setChoices(List<Choice> choices) {
    this.choices = choices;
  }

  private List<Choice> choices = new ArrayList<>();

  public static class Choice {

    private String choice;

    private Integer votes;

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
}

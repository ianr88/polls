package polls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

  @Autowired private QuestionsRepository questionsRepository;

  @GetMapping
  public List<Question> findAll() {
    return questionsRepository.findAll();
  }

  @GetMapping("{id}")
  public Question findById(@PathVariable Integer id) {
    return questionsRepository
        .findById(id)
        .orElseThrow(
            () -> new RuntimeException(String.format("%s not found: %s", Question.class, id)));
  }

  @PostMapping
  public ResponseEntity<Question> createAddress(@RequestBody @Valid CreateQuestionRequest request) {

    Question question = new Question();
    question.setPublished_at(request.getPublishedAt());
    question.setQuestion(request.getQuestion());
    List<Choice> choices =
        request
            .getChoices()
            .stream()
            .map(e -> new Choice(e.getChoice(), e.getVotes()))
            .collect(Collectors.toList());
    question.setChoices(choices);
    Question questionSaved = questionsRepository.saveAndFlush(question);

    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(questionSaved.getId())
            .toUri();
    return ResponseEntity.created(location).body(questionSaved);
  }
}

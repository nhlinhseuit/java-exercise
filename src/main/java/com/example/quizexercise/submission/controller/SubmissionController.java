package com.example.quizexercise.submission.controller;
import com.example.quizexercise.submission.controller.dto.request.CreateSubmissionRequestDto;
import com.example.quizexercise.submission.controller.dto.response.CreateSubmissionResponseDto;
import com.example.quizexercise.user.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/submissions")
@RequiredArgsConstructor
public class SubmissionController {
    private final SubmissionService submissionService;

//    @GetMapping
//    @ApiResponses(value = {})
//    public List<GetSubmissionResponseDto> getSubmissionList(
//            @RequestBody GetSubmissionListRequestDto getSubmissionListRequestDto) {
//        return submissionService.getSubmissionList(getSubmissionListRequestDto);
//    }

    @PostMapping
    public CreateSubmissionResponseDto createSubmission(
            @RequestBody CreateSubmissionRequestDto createSubmissionRequestDto) {
        return submissionService.createSubmission(createSubmissionRequestDto);
    }

//    @GetMapping("/{submissionId}")
//    @Operation(
//            summary = "Get submission by id",
//            description = "Return the submission based on submission id."
//    )
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Success"),
//            @ApiResponse(responseCode = "404", description = "TEMP: Submission id not found"),
//            @ApiResponse(responseCode = "500", description = "TEMP: Internal error")
//    })
//    public GetSubmissionResponseDto getSubmission(@PathVariable("submissionId") String submissionId) {
//        return submissionService.getSubmission(submissionId);
//    }
}

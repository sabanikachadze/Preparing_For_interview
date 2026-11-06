package org.example.web;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class Web {
    record CreateWorkshopRequest(@NotBlank String title, @Min(1) int seats) {
    }

    record WorkshopResponse(long id, String title, int seats) {
    }

    class DuplicateTitleException extends RuntimeException {
        DuplicateTitleException(String title) {
            super(title);
        }
    }

    interface WorkshopService {
        WorkshopResponse create(CreateWorkshopRequest request);
    }

    @RestController
    @RequestMapping("/workshops")
    class WorkshopController {
        private final WorkshopService service;

        WorkshopController(WorkshopService service) {
            this.service = service;
        }

        @PostMapping
        public ResponseEntity<WorkshopResponse> createWorkShop(@Valid @RequestBody CreateWorkshopRequest request){
            WorkshopResponse response;

            try {

                response = service.create(request);

            } catch(DuplicateTitleException e){
                    return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
    }
}

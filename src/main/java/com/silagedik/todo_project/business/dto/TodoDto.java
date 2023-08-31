package com.silagedik.todo_project.business.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.silagedik.todo_project.auditing.AuditingAwareBaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;


//LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class TodoDto extends AuditingAwareBaseDto implements Serializable
{
    //serileştirme => bir veriyi başka bir yere taşırken herhangi bir sıkıntı yaşamamak için kullanırız
    public static final Long serialVersionUID= 1L;

   // private Long id;

    @NotEmpty(message= "Todo cannot be empty")
    private String todoContent;
    private boolean done;
}

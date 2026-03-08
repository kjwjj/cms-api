package com.malgn.content.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class ContentCreateDto {

    @NotBlank(message="제목은 필수입니다.")
    @Size(max=50, message="제목은 50자 이하입니다.")
    private String title;

    private String description;
}

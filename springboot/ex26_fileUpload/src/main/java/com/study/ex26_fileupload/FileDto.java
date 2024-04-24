package com.study.ex26_fileupload;

import lombok.Builder;

@Builder
public record FileDto(
        String uuid,
        String fileName,
        String contentType
) {
}

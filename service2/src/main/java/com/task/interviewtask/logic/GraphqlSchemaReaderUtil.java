package com.task.interviewtask.logic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public final class GraphqlSchemaReaderUtil {

    public static String getSchemaFromFileName(final String filename) throws IOException {
        return new String(GraphqlSchemaReaderUtil.class.getClassLoader().getResourceAsStream(filename + ".graphql").readAllBytes());
    }
}

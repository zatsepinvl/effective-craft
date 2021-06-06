package com.effective.playground.spring.graphql;

import graphql.schema.DataFetcher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    @Data
    @AllArgsConstructor
    public static class Book {
        String id;
        String name;
        int pageCount;
        String authorId;
    }

    @Data
    @AllArgsConstructor
    public static class Author {
        String id;
        String firstName;
        String lastName;
    }

    private static final List<Book> books = Arrays.asList(
            new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"),
            new Book("book-2", "Moby Dick", 635, "author-2"),
            new Book("book-3", "Interview with the vampire", 371, "author-3")
    );

    private static final List<Author> authors = Arrays.asList(
            new Author("author-1", "Joanne", "Rowling"),
            new Author("author-2", "Herman", "Melville"),
            new Author("author-3", "Anne", "Rice")
    );

    public DataFetcher<Book> getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return books
                    .stream()
                    .filter(book -> book.getId().equals(bookId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher<Author> getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            String authorId = book.getAuthorId();
            return authors
                    .stream()
                    .filter(author -> author.getId().equals(authorId))
                    .findFirst()
                    .orElse(null);
        };
    }
}

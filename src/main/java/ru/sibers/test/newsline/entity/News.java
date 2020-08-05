package ru.sibers.test.newsline.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author Lyubov Bochkareva
 * @since 05.05.2020
 */

@Data
@Entity
@Table(name = "news", schema = "news_line")
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Please fill the heading")
	private String heading;
	private LocalDateTime publicationDate;
	@NotBlank(message = "Please fill the text news")
	private String text;
	private String filename;

	public News(String heading, LocalDateTime publicationDate, String text) {
		this.heading = heading;
		this.publicationDate = publicationDate;
		this.text = text;
	}

	public News() {

	}

	public News(String heading, LocalDateTime publicationDate, String text, String filename) {
		this.heading = heading;
		this.publicationDate = publicationDate;
		this.text = text;
		this.filename = filename;
	}
}
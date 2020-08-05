package ru.sibers.test.newsline.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.sibers.test.newsline.entity.News;
import ru.sibers.test.newsline.repository.NewsRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

/**
 * @author Lyubov Bochkareva
 * @since 05.05.2020
 */

@Component
public class AppInitializer {

	private NewsRepository newsRepository;

	@Value("${upload.path}")
	private String uploadPath;

	public AppInitializer(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}

	public void init() {
		Path dir = Paths.get(uploadPath);
		try {
			Files.createDirectories(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 5, 4, 10, 0), "На 10 часов 4 мая в Новосибирской области за сутки коронавирусую инфекцию выявили у 61 человека.", "3e5754d7-da7c-4c71-81d7-9e528427f88c.оперативный штаб 54 (10).png"));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 5, 3, 12, 0), "По данным оперативного штаба на 12 часов 3 мая в Новосибирской области за сутки диагноз “коронавирусная инфекция” подтвержден у 51 человека.", "5a376ab9-efb2-4c1c-a16b-c7af04781bec.оперативный штаб 54 (21).png"));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 5, 7, 11, 42), "По данным оперативного штаба на 11 утра 7 мая в Новосибирской области за сутки коронавирусную инфекцию выявили у 67 человек.", "4132486c-e0c0-40bc-9d66-6b7b449e04eb.оперативный штаб 54 (13).png"));
		newsRepository.save(new News("Погода", LocalDateTime.of(2020, 5, 4, 12, 6), "Резкое похолодание пришло в Новосибирск 4 мая. В некоторых районах города лег снег"));
		newsRepository.save(new News("Фондовая биржа", LocalDateTime.of(2020, 5, 5, 14, 1), "На открытии дня стоимость фьючерса на нефть марки Brent 26,48 в долларах США за 1 баррель"));
		newsRepository.save(new News("Фондовая биржа", LocalDateTime.of(2020, 5, 5, 23, 56), "Закрытие дня... стоимость фьючерса на нефть марки Brent 30,48 в долларах США за 1 баррель"));
		newsRepository.save(new News("Погода", LocalDateTime.of(2020, 5, 5, 12, 0), "В Новосибирске +9, дождь"));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 5, 5, 11, 0), "По данным оперативного штаба на 11 часов 5 мая в Новосибирской области за сутки коронавирусую инфекцию выявили у 65 человек", "3f10d562-f5c9-4032-a868-da6d1a852d2f.оперативный штаб 54 (11).png"));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 5, 6, 11, 0), "По данным оперативного штаба на 11 утра 6 мая в Новосибирской области за сутки коронавирусная инфекция лабораторно подтверждена у 63 человек.", "dcbad879-732d-41ee-a571-e14d7161a716.оперативный штаб 54 (12).png"));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 5, 2, 12, 58), "По данным оперативного штаба на 12 часов 2 мая в Новосибирской области за сутки коронавирусную инфекцию выявили у 43 человек. 2 человека скончались. ", "628b7752-a033-4501-8cf7-e54858791730.оперативный штаб 54 (19).png"));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 5, 1, 11, 37), "По данным оперативного штаба на 11 утра 1 мая в Новосибирской области за сутки коронавирусная инфекция лабораторно подтверждена у 55 человек.", "e8a27109-93ef-485c-ad2a-2f7cf6bce229.оперативный штаб 54 (17).png"));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 5, 5, 14, 41), "Всего в России зарегистрировано 155370 заболевших в 85 регионах"));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 3, 25, 20, 41), "В Новосибирске введен всеобщий режим самоизоляции: Покидать квартиру разрешается только в особых случаях"));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 3, 30, 19, 13), "«Яндекс» запустил счётчик уровня самоизоляции по аналогии с сервисом «Пробки»"));
		newsRepository.save(new News("Фондовая биржа", LocalDateTime.of(2020, 4, 21, 19, 13), "Фьючерсы на нефть марки Brent в ходе торгов во вторник опустились ниже $20 за баррель впервые с февраля 2002 года."));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 4, 1, 11, 0), "#сидим дома"));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 3, 30, 14, 26), "Первого в Новосибирске мужчину с коронавирусом госпитализировали через суд"));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 3, 25, 11, 29), "В детскую больницу № 3 госпитализированы 7 детей. За сутки в медучреждение поступили двое детей с признаками ОРВИ, они вернулись из Таиланда и Вьетнама."));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 3, 30, 7, 40), "Новосибирский колледж начал изготавливать защитные маски"));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 3, 30, 8, 11), "Тесты на COVID-19 будут проводить в инфекционной больнице №1 "));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 3, 30, 21, 8), "В США число зараженных COVID-19 достигло 142,5 тыс. человек"));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 3, 30, 20, 21), "В Брянске возбуждено первое уголовное дело о нарушении режима самоизоляции."));
		newsRepository.save(new News("законопроект", LocalDateTime.of(2020, 3, 30, 21, 17), "В Госдуму РФ внесен законопроект, который вводит в РФ налогообложение доходов от процентов по вкладам, превышающим 1 млн рублей."));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 4, 3, 8, 58), "Самоизоляция. На улице почти никого. Спасибо всем, кто дома."));
		newsRepository.save(new News("коронавирус", LocalDateTime.of(2020, 5, 7, 14, 32), " Масочный режим в Новосибирской области ввели с 27 апреля 2020 года в целях предотвращения распространения коронавируса. Маски необходимо носить не только в торговых точках, но и в общественном транспорте.", "730a5cf4-0ede-42d4-845e-7bfa5c36a7fa.cd98bfc128467dc51bccc27faea6ea63.jpg"));
	}
}
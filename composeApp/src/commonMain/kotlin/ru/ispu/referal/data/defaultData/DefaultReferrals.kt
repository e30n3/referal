package ru.ispu.referal.data.defaultData

import ru.ispu.referal.domain.model.Referral
import ru.ispu.referal.domain.model.ReferralStatus

object DefaultReferrals {
    private val defaultComment
        get() = listOf(
            "Я встретил клиента на автомобильной выставке, где проводил презентацию новейших моделей BMW. Клиент заинтересовался, так как ищет автомобиль с высокими техническими характеристиками и современной системой безопасности для своей семьи.",
            "Я познакомился с клиентом через общих друзей на корпоративном мероприятии. Клиент давно мечтал об электрическом автомобиле и, узнав, что я представляю Tesla, захотел узнать больше о Model S, которая славится своими инновационными технологиями и экологичностью.",
            "Клиент нашел меня через социальные сети, когда увидел мой рекламный пост о новых моделях Mercedes-Benz. Клиент был впечатлен надежностью и статусом марки, что идеально подходит для его деловых поездок и создания имиджа успешного предпринимателя.",
            "Я встретился с клиентом на международной конференции по инновациям в автомобильной индустрии. Клиент заинтересовался автомобилями Volvo благодаря их репутации в области безопасности и продвинутым функциям автономного вождения, которые он хотел бы испытать на себе.",
            "Клиент познакомился со мной во время премиального ужина для владельцев элитных автомобилей. Клиент был впечатлен новой линейкой BMW, особенно интересовала модель, обеспечивающая высокий уровень комфорта и роскоши, что важно для его деловых поездок.",
            "Я встретил клиента на модном показе, где он проявил интерес к марке Mercedes-Benz. Клиент искал автомобиль, сочетающий элегантность и мощность, что идеально соответствует его стилю жизни и потребностям.",
            "Клиент узнал обо мне через рекомендации коллег по работе. Клиент хотел приобрести Volvo для своей семьи из-за высокой степени безопасности и надежности, что является основным приоритетом для него как для отца двух детей.",
            "Я встретил клиента на деловом ужине, организованном местной торговой палатой. Клиент был в поиске стильного и надежного автомобиля, и BMW привлек его внимание благодаря своему высокому качеству и престижу, что важно для его профессионального имиджа.",
            "Клиент познакомился со мной на спортивном мероприятии. Клиент давно хотел обновить свой автомобильный парк и заинтересовался новыми моделями BMW, особенно из-за их спортивного дизайна и передовых технологий, которые соответствуют его активному образу жизни.",
            "Я встретил клиента на презентации новинок электроники, где Tesla проводила демонстрацию своих последних моделей. Клиент искал экологически чистый и технологичный автомобиль, и Model 3 привлек его внимание благодаря своему автономному вождению и элегантному дизайну."
        ).random()


    val referrals = listOf(
        Referral(
            client = "Виктор М.",
            agent = "Андрей Б.",
            company = "BMW",
            phone = "+7 912 345-67-89",
            email = "viktor.m@example.com",
            comment = defaultComment,
            date = "14.03.2024",
            status = ReferralStatus.CREATED
        ), Referral(
            client = "Борис В.",
            agent = "Андрей Б.",
            company = "Tesla",
            phone = "+7 912 346-67-80",
            email = "boris.v@example.com",
            comment = defaultComment,
            date = "12.03.2024",
            status = ReferralStatus.SIGNED
        ), Referral(
            client = "Елисей Е.",
            agent = "Андрей Б.",
            company = "Mercedes-Benz",
            phone = "+7 912 347-67-81",
            email = "elisey.e@example.com",
            comment = defaultComment,
            date = "07.03.2024",
            status = ReferralStatus.IN_PROGRESS
        ), Referral(
            client = "Данил В.",
            agent = "Андрей Б.",
            company = "Volvo",
            phone = "+7 912 348-67-82",
            email = "danil.v@example.com",
            comment = defaultComment,
            date = "01.03.2024",
            status = ReferralStatus.PAYED
        ), Referral(
            client = "Алексей А.",
            agent = "Андрей Б.",
            company = "BMW",
            phone = "+7 912 349-67-83",
            email = "alexey.a@example.com",
            comment = defaultComment,
            date = "28.02.2024",
            status = ReferralStatus.FAILED
        ), Referral(
            client = "София С.",
            agent = "Андрей Б.",
            company = "Mercedes-Benz",
            phone = "+7 912 350-67-84",
            email = "sofia.s@example.com",
            comment = defaultComment,
            date = "15.02.2024",
            status = ReferralStatus.ACCEPTED
        ), Referral(
            client = "Михаил Д.",
            agent = "Андрей Б.",
            company = "Volvo",
            phone = "+7 912 351-67-85",
            email = "mikhail.d@example.com",
            comment = defaultComment,
            date = "10.02.2024",
            status = ReferralStatus.OFFERED
        ), Referral(
            client = "Ирина Ш.",
            agent = "Андрей Б.",
            company = "BMW",
            phone = "+7 912 352-67-86",
            email = "irina.s@example.com",
            comment = defaultComment,
            date = "05.02.2024",
            status = ReferralStatus.COMPLETED
        ), Referral(
            client = "Олег Н.",
            agent = "Андрей Б.",
            company = "BMW",
            phone = "+7 912 353-67-87",
            email = "oleg.n@example.com",
            comment = defaultComment,
            date = "20.01.2024",
            status = ReferralStatus.PAYING
        ),


        Referral(
            client = "Сергей К.",
            agent = "Иван З.",
            company = "BMW",
            phone = "+7 912 360-12-34",
            email = "sergey.k@example.com",
            comment = defaultComment,
            date = "10.04.2024",
            status = ReferralStatus.CREATED
        ),
        Referral(
            client = "Наталья Л.",
            agent = "Иван З.",
            company = "Tesla",
            phone = "+7 912 361-12-35",
            email = "natalya.l@example.com",
            comment = defaultComment,
            date = "08.04.2024",
            status = ReferralStatus.SIGNED
        ),
        Referral(
            client = "Андрей П.",
            agent = "Иван З.",
            company = "Mercedes-Benz",
            phone = "+7 912 362-12-36",
            email = "andrey.p@example.com",
            comment = defaultComment,
            date = "05.04.2024",
            status = ReferralStatus.IN_PROGRESS
        ),
        Referral(
            client = "Екатерина С.",
            agent = "Иван З.",
            company = "Volvo",
            phone = "+7 912 363-12-37",
            email = "ekaterina.s@example.com",
            comment = defaultComment,
            date = "02.04.2024",
            status = ReferralStatus.PAYED
        ),
        Referral(
            client = "Олег Р.",
            agent = "Иван З.",
            company = "Louis Vuitton",
            phone = "+7 912 364-12-38",
            email = "oleg.r@example.com",
            comment = defaultComment,
            date = "30.03.2024",
            status = ReferralStatus.FAILED
        ),
        Referral(
            client = "Мария К.",
            agent = "Иван З.",
            company = "VISA",
            phone = "+7 912 365-12-39",
            email = "maria.k@example.com",
            comment = defaultComment,
            date = "25.03.2024",
            status = ReferralStatus.ACCEPTED
        ),
        Referral(
            client = "Иван И.",
            agent = "Иван З.",
            company = "MasterCard",
            phone = "+7 912 366-12-40",
            email = "ivan.i@example.com",
            comment = defaultComment,
            date = "20.03.2024",
            status = ReferralStatus.OFFERED
        ),
        Referral(
            client = "Светлана М.",
            agent = "Иван З.",
            company = "BMW",
            phone = "+7 912 367-12-41",
            email = "svetlana.m@example.com",
            comment = defaultComment,
            date = "15.03.2024",
            status = ReferralStatus.COMPLETED
        ),
        Referral(
            client = "Дмитрий Н.",
            agent = "Иван З.",
            company = "Mercedes-Benz",
            phone = "+7 912 368-12-42",
            email = "dmitry.n@example.com",
            comment = defaultComment,
            date = "10.03.2024",
            status = ReferralStatus.PAYING
        ),


        Referral(
            client = "Александр Н.",
            agent = "Мария П.",
            company = "Volvo",
            phone = "+7 912 370-12-34",
            email = "alexander.n@example.com",
            comment = defaultComment,
            date = "12.04.2024",
            status = ReferralStatus.CREATED
        ),
        Referral(
            client = "Ольга К.",
            agent = "Мария П.",
            company = "Tesla",
            phone = "+7 912 371-12-35",
            email = "olga.k@example.com",
            comment = defaultComment,
            date = "10.04.2024",
            status = ReferralStatus.SIGNED
        ),
        Referral(
            client = "Игорь Л.",
            agent = "Мария П.",
            company = "BMW",
            phone = "+7 912 372-12-36",
            email = "igor.l@example.com",
            comment = defaultComment,
            date = "07.04.2024",
            status = ReferralStatus.IN_PROGRESS
        ),
        Referral(
            client = "Елена Ф.",
            agent = "Мария П.",
            company = "Louis Vuitton",
            phone = "+7 912 373-12-37",
            email = "elena.f@example.com",
            comment = defaultComment,
            date = "04.04.2024",
            status = ReferralStatus.PAYED
        ),
        Referral(
            client = "Станислав В.",
            agent = "Мария П.",
            company = "Mercedes-Benz",
            phone = "+7 912 374-12-38",
            email = "stanislav.v@example.com",
            comment = defaultComment,
            date = "01.04.2024",
            status = ReferralStatus.FAILED
        ),
        Referral(
            client = "Анна Г.",
            agent = "Мария П.",
            company = "VISA",
            phone = "+7 912 375-12-39",
            email = "anna.g@example.com",
            comment = defaultComment,
            date = "28.03.2024",
            status = ReferralStatus.ACCEPTED
        ),
        Referral(
            client = "Николай Д.",
            agent = "Мария П.",
            company = "MasterCard",
            phone = "+7 912 376-12-40",
            email = "nikolay.d@example.com",
            comment = defaultComment,
            date = "25.03.2024",
            status = ReferralStatus.OFFERED
        ),
        Referral(
            client = "Виктория Е.",
            agent = "Мария П.",
            company = "Volvo",
            phone = "+7 912 377-12-41",
            email = "victoria.e@example.com",
            comment = defaultComment,
            date = "22.03.2024",
            status = ReferralStatus.COMPLETED
        ),
        Referral(
            client = "Сергей Ж.",
            agent = "Мария П.",
            company = "BMW",
            phone = "+7 912 378-12-42",
            email = "sergey.z@example.com",
            comment = defaultComment,
            date = "19.03.2024",
            status = ReferralStatus.PAYING
        ),


        Referral(
            client = "Татьяна М.",
            agent = "Антон Л.",
            company = "Tesla",
            phone = "+7 912 380-12-34",
            email = "tatiana.m@example.com",
            comment = defaultComment,
            date = "11.04.2024",
            status = ReferralStatus.CREATED
        ),
        Referral(
            client = "Алексей О.",
            agent = "Антон Л.",
            company = "Mercedes-Benz",
            phone = "+7 912 381-12-35",
            email = "alexey.o@example.com",
            comment = defaultComment,
            date = "09.04.2024",
            status = ReferralStatus.SIGNED
        ),
        Referral(
            client = "Лариса П.",
            agent = "Антон Л.",
            company = "BMW",
            phone = "+7 912 382-12-36",
            email = "larisa.p@example.com",
            comment = defaultComment,
            date = "06.04.2024",
            status = ReferralStatus.IN_PROGRESS
        ),
        Referral(
            client = "Владимир Р.",
            agent = "Антон Л.",
            company = "Louis Vuitton",
            phone = "+7 912 383-12-37",
            email = "vladimir.r@example.com",
            comment = defaultComment,
            date = "03.04.2024",
            status = ReferralStatus.PAYED
        ),
        Referral(
            client = "Евгения С.",
            agent = "Антон Л.",
            company = "VISA",
            phone = "+7 912 384-12-38",
            email = "evgenia.s@example.com",
            comment = defaultComment,
            date = "31.03.2024",
            status = ReferralStatus.FAILED
        ),
        Referral(
            client = "Максим Т.",
            agent = "Антон Л.",
            company = "Volvo",
            phone = "+7 912 385-12-39",
            email = "maksim.t@example.com",
            comment = defaultComment,
            date = "29.03.2024",
            status = ReferralStatus.ACCEPTED
        ),
        Referral(
            client = "Инна У.",
            agent = "Антон Л.",
            company = "MasterCard",
            phone = "+7 912 386-12-40",
            email = "inna.u@example.com",
            comment = defaultComment,
            date = "27.03.2024",
            status = ReferralStatus.OFFERED
        ),
        Referral(
            client = "Денис Ф.",
            agent = "Антон Л.",
            company = "Tesla",
            phone = "+7 912 387-12-41",
            email = "denis.f@example.com",
            comment = defaultComment,
            date = "24.03.2024",
            status = ReferralStatus.COMPLETED
        ),
        Referral(
            client = "Юлия Х.",
            agent = "Антон Л.",
            company = "BMW",
            phone = "+7 912 388-12-42",
            email = "yulia.h@example.com",
            comment = defaultComment,
            date = "21.03.2024",
            status = ReferralStatus.PAYING
        ),


        Referral(
            client = "Оксана Ц.",
            agent = "Виктор С.",
            company = "Volvo",
            phone = "+7 912 390-12-34",
            email = "oksana.c@example.com",
            comment = defaultComment,
            date = "13.04.2024",
            status = ReferralStatus.CREATED
        ),
        Referral(
            client = "Павел Ч.",
            agent = "Виктор С.",
            company = "Mercedes-Benz",
            phone = "+7 912 391-12-35",
            email = "pavel.ch@example.com",
            comment = defaultComment,
            date = "11.04.2024",
            status = ReferralStatus.SIGNED
        ),
        Referral(
            client = "Юрий Ш.",
            agent = "Виктор С.",
            company = "BMW",
            phone = "+7 912 392-12-36",
            email = "yuri.sh@example.com",
            comment = defaultComment,
            date = "08.04.2024",
            status = ReferralStatus.IN_PROGRESS
        ),
        Referral(
            client = "Евдокия Щ.",
            agent = "Виктор С.",
            company = "Louis Vuitton",
            phone = "+7 912 393-12-37",
            email = "evdokia.sh@example.com",
            comment = defaultComment,
            date = "05.04.2024",
            status = ReferralStatus.PAYED
        ),
        Referral(
            client = "Валентин Э.",
            agent = "Виктор С.",
            company = "VISA",
            phone = "+7 912 394-12-38",
            email = "valentin.e@example.com",
            comment = defaultComment,
            date = "02.04.2024",
            status = ReferralStatus.FAILED
        ),
        Referral(
            client = "Маргарита Ю.",
            agent = "Виктор С.",
            company = "MasterCard",
            phone = "+7 912 395-12-39",
            email = "margarita.y@example.com",
            comment = defaultComment,
            date = "30.03.2024",
            status = ReferralStatus.ACCEPTED
        ),
        Referral(
            client = "Константин Я.",
            agent = "Виктор С.",
            company = "Volvo",
            phone = "+7 912 396-12-40",
            email = "konstantin.ya@example.com",
            comment = defaultComment,
            date = "27.03.2024",
            status = ReferralStatus.OFFERED
        ),
        Referral(
            client = "Анастасия Ж.",
            agent = "Виктор С.",
            company = "BMW",
            phone = "+7 912 397-12-41",
            email = "anastasia.zh@example.com",
            comment = defaultComment,
            date = "24.03.2024",
            status = ReferralStatus.COMPLETED
        ),
        Referral(
            client = "Даниил Б.",
            agent = "Виктор С.",
            company = "Mercedes-Benz",
            phone = "+7 912 398-12-42",
            email = "daniil.b@example.com",
            comment = defaultComment,
            date = "21.03.2024",
            status = ReferralStatus.PAYING
        ),


        Referral(
            client = "Федор А.",
            agent = "Екатерина М.",
            company = "Tesla",
            phone = "+7 912 400-12-34",
            email = "fedor.a@example.com",
            comment = defaultComment,
            date = "10.04.2024",
            status = ReferralStatus.CREATED
        ),
        Referral(
            client = "Зоя В.",
            agent = "Екатерина М.",
            company = "Volvo",
            phone = "+7 912 401-12-35",
            email = "zoya.v@example.com",
            comment = defaultComment,
            date = "08.04.2024",
            status = ReferralStatus.SIGNED
        ),
        Referral(
            client = "Артур Г.",
            agent = "Екатерина М.",
            company = "BMW",
            phone = "+7 912 402-12-36",
            email = "artur.g@example.com",
            comment = defaultComment,
            date = "05.04.2024",
            status = ReferralStatus.IN_PROGRESS
        ),
        Referral(
            client = "Галина Д.",
            agent = "Екатерина М.",
            company = "Louis Vuitton",
            phone = "+7 912 403-12-37",
            email = "galina.d@example.com",
            comment = defaultComment,
            date = "02.04.2024",
            status = ReferralStatus.PAYED
        ),
        Referral(
            client = "Владислав Е.",
            agent = "Екатерина М.",
            company = "Mercedes-Benz",
            phone = "+7 912 404-12-38",
            email = "vladislav.e@example.com",
            comment = defaultComment,
            date = "30.03.2024",
            status = ReferralStatus.FAILED
        ),
        Referral(
            client = "Ирина Ж.",
            agent = "Екатерина М.",
            company = "VISA",
            phone = "+7 912 405-12-39",
            email = "irina.z@example.com",
            comment = defaultComment,
            date = "27.03.2024",
            status = ReferralStatus.ACCEPTED
        ),
        Referral(
            client = "Анатолий И.",
            agent = "Екатерина М.",
            company = "MasterCard",
            phone = "+7 912 406-12-40",
            email = "anatoly.i@example.com",
            comment = defaultComment,
            date = "24.03.2024",
            status = ReferralStatus.OFFERED
        ),
        Referral(
            client = "Наталия К.",
            agent = "Екатерина М.",
            company = "Tesla",
            phone = "+7 912 407-12-41",
            email = "natalia.k@example.com",
            comment = defaultComment,
            date = "21.03.2024",
            status = ReferralStatus.COMPLETED
        ),
        Referral(
            client = "Станислав Л.",
            agent = "Екатерина М.",
            company = "BMW",
            phone = "+7 912 408-12-42",
            email = "stanislav.l@example.com",
            comment = defaultComment,
            date = "18.03.2024",
            status = ReferralStatus.PAYING
        ),


        Referral(
            client = "Юлия С.",
            agent = "Павел Р.",
            company = "Volvo",
            phone = "+7 912 410-12-34",
            email = "yulia.s@example.com",
            comment = defaultComment,
            date = "12.04.2024",
            status = ReferralStatus.CREATED
        ),
        Referral(
            client = "Артем Т.",
            agent = "Павел Р.",
            company = "Mercedes-Benz",
            phone = "+7 912 411-12-35",
            email = "artem.t@example.com",
            comment = defaultComment,
            date = "09.04.2024",
            status = ReferralStatus.SIGNED
        ),
        Referral(
            client = "Григорий У.",
            agent = "Павел Р.",
            company = "Tesla",
            phone = "+7 912 412-12-36",
            email = "grigory.u@example.com",
            comment = defaultComment,
            date = "07.04.2024",
            status = ReferralStatus.IN_PROGRESS
        ),
        Referral(
            client = "Вероника Ф.",
            agent = "Павел Р.",
            company = "BMW",
            phone = "+7 912 413-12-37",
            email = "veronika.f@example.com",
            comment = defaultComment,
            date = "05.04.2024",
            status = ReferralStatus.PAYED
        ),
        Referral(
            client = "Александр Х.",
            agent = "Павел Р.",
            company = "Louis Vuitton",
            phone = "+7 912 414-12-38",
            email = "alexander.h@example.com",
            comment = defaultComment,
            date = "02.04.2024",
            status = ReferralStatus.FAILED
        ),
        Referral(
            client = "Полина Ц.",
            agent = "Павел Р.",
            company = "VISA",
            phone = "+7 912 415-12-39",
            email = "polina.c@example.com",
            comment = defaultComment,
            date = "30.03.2024",
            status = ReferralStatus.ACCEPTED
        ),
        Referral(
            client = "Егор Ч.",
            agent = "Павел Р.",
            company = "MasterCard",
            phone = "+7 912 416-12-40",
            email = "egor.ch@example.com",
            comment = defaultComment,
            date = "28.03.2024",
            status = ReferralStatus.OFFERED
        ),
        Referral(
            client = "Елена Ш.",
            agent = "Павел Р.",
            company = "Volvo",
            phone = "+7 912 417-12-41",
            email = "elena.sh@example.com",
            comment = defaultComment,
            date = "25.03.2024",
            status = ReferralStatus.COMPLETED
        ),
        Referral(
            client = "Анатолий Щ.",
            agent = "Павел Р.",
            company = "BMW",
            phone = "+7 912 418-12-42",
            email = "anatoly.sh@example.com",
            comment = defaultComment,
            date = "22.03.2024",
            status = ReferralStatus.PAYING
        )

    )
}
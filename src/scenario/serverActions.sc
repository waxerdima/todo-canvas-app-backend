# Когда приходит ServerAction, сообщение прилетает в состояние, 
# с условием на вход action_id.
# пример:
#     event!: action_id

theme: /
    
    state: ЗаданиеВыполнено
        event!: done
        event!: DONE

        script:
            $jsapi.log('!!!!!!555555')
            $temp.gender = $request.rawRequest.payload.character.gender;
            
        if: $request && $request.data && $request.data.eventData && $request.data.eventData.note
            if: $temp.gender == "male"
                a: Закрыл {{ $request.data.eventData.note }}! Молодец!
            elseif: $temp.gender == "female"
                a: Закрыла {{ $request.data.eventData.note }}! Молодец!
            else:
                a: Закрыто
        else:
            random: 
                a: Молодец!
                a: Красавчик!
                a: Супер!
                
        buttons:
            "Запиши купить молоко"
            "Добавь запись помыть машину"
            "Выйди"


    state: TaskDone
        event!: done
        event!: DONE

        script:
            $jsapi.log('!!!!!!555555')
            $temp.gender = $request.rawRequest.payload.character.gender;
            
        if: $request && $request.data && $request.data.eventData && $request.data.eventData.note
            if: $temp.gender == "male"
                a: Done {{ $request.data.eventData.note }}! Good!
            elseif: $temp.gender == "female"
                a: Done {{ $request.data.eventData.note }}! Good!
            else:
                a: Close
        else:
            random: 
                a:  Russia's president wants to encourage people to get vaccinated but gets his jab behind closed doors. Europe Putin gets Covid jab but without cameras!
                a: Putin gets Covid jab but without cameras !
                a: Russia's president wants to encourage people to get vaccinated but gets his jab behind closed doors.
                
        buttons:
            "Запиши купить молоко"
            "Добавь запись помыть машину"
            "Выйди"

           
    state: ДобавленаНоваяЗапись
        event!: note_added
        event!: NOTE_ADDED

        random: 
            a: Добавлено!
            a: Сохранено!
            a: Записано!
        
        buttons:
            "Запиши купить молоко"
            "Добавь запись помыть машину"
            "Выйди"
            
theme: /

    state: УдалениеЭлементаПоНомеру
        q!: (~удалить|удали) номер
            @duckling.number:: digit
            $weight<1.001>
        
        script:
            var itemId = findItemIdByNumber(
                $parseTree._digit,
                getRequest($context)
            )
            deleteNote(itemId, $context);

        buttons:
            "Добавь запись выбросить мусор (по номеру)"
        
        script:
            log($request)
            log($context)
            log($parseTree)


    state: УдалениеЭлемента
        q!: (~удалить|удали)
            $AnyText::anyText
            $weight<-0.8>
            
        
        script:
            deleteNote(
                findItemIdBySelectedItem(getRequest($context)),
                $context
            );
        
        buttons:
            "Добавь запись выбросить мусор"

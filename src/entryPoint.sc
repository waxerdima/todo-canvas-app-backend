require: slotfilling/slotFilling.sc
  module = sys.zb-common
require: common.js
  module = sys.zb-common
# Подключение javascript обработчиков
require: js/getters.js
require: js/reply.js
require: js/actions.js
require: js/findItem.js

# Подключение сценарных файлов
require: scenario/addNote.sc
require: scenario/doNote.sc
require: scenario/deleteNote.sc
require: scenario/serverActions.sc


patterns:
    $AnyText = $nonEmptyGarbage
    
    # Паттерны для запуска сценария
    $OpenSkipWords = (хочу|мне|мое|моё|пожалуйста|в|прошу|тебя|может|с)
    $OpenKeyWords = (включи|включить|включай|запусти|запустить|запускай|играть|
        поиграть|поиграем|навык|игра|игру|скил|скилл|приложение|апп|сыграем|
        открой|поиграй со мной|сыграть|давай играть|активируй|давай|поиграем)
    $projectName = (Название вашего навыка)


theme: /
    state: Запуск
        q!: * $Number::num
        script: $temp.age = parseInt($parseTree.value);
        if:     $temp.age > 18
            a: Больше 18
        elseif: $temp.age == 18
            a: Ровно 18
        else:
            a: Меньше 18

    state: Fallback
        event!: noMatch
        a: Я не понимаю.

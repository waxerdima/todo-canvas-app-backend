function findItemIdBySelectedItem(request) {
    var items = getItems(request);
    $jsapi.log('items 1' + items + request);
    $jsapi.log(items);
    $jsapi.log(request);
    var selectedItem = getSelectedItem(request);
    $jsapi.log(selectedItem);
    if (selectedItem && items && items.length > selectedItem.index) {
        $jsapi.log('items xxx');
        return items[selectedItem.index].id;
    }
    $jsapi.log('items null');
    return null;
}

function findItemIdByNumber(number, request) {
    var items = getItems(request);
    $jsapi.log('items' + items);
    if (items && items.length) {
        for (var ind = 0; ind < items.length; ind++) {
            $jsapi.log('items for ' + items[ind].number + ' ' + number);
            if (items[ind].number == number) {
                $jsapi.log('items for ' + items[ind].id);
                return items[ind].id;
            }
        }
    }
    return null;
}

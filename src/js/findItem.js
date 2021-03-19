function findItemIdBySelectedItem(request) {
    var items = getItems(request);
    $jsapi.log('items 1' + items);
    var selectedItem = getSelectedItem(request);
    if (selectedItem && items && items.length > selectedItem.index) {
        return items[selectedItem.index].id;
    }
    return null;
}

function findItemIdByNumber(number, request) {
    var items = getItems(request);
    $jsapi.log('items' + items);
    if (items && items.length) {
        for (var ind = 0; ind < items.length; ind++) {
            if (items[ind].number == number) {
                return items[ind].id;
            }
        }
    }
    return null;
}

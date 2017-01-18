package LinkedListPackage;

class List<T> {
    private class ListElement<T> {
        T parameter;
        ListElement next;
    }

    private ListElement first;
    private ListElement last;

    public String toString() {
        ListElement first1 = first;
        String s = "[";

        while (first1 != null) {  // условие обхода
            if (first1.next == null)
                s = s + first1.parameter;
            else
                s = s + first1.parameter + ",";
            first1 = first1.next;
        }
        return s + "]";
    }

    //Добавление элемента в начало списка
    void addToFront(T parameter) {
        ListElement newElem = new ListElement();
        newElem.parameter = parameter;
        if (first == null) {
            first = newElem;
            last = newElem;
        } else {
            newElem.next = first;
            first = newElem;
        }
    }

    //Добавление элемента в конец списка
    void addToBack(T parameter) {
        ListElement newElem = new ListElement();
        newElem.parameter = parameter;
        if (last == null) {
            first = newElem;
            last = newElem;
        } else {
            last.next = newElem;
            last = newElem;
        }
    }

    // Удаление сначала
    void deleteFromBegin() throws SpecialException {
        if (first == null)
            throw new SpecialException("Cannot delete from empty list");
        first = first.next;
    }

    // Удаление вконце
    void deleteFromEnd() throws SpecialException {
        if (first == null)
            throw new SpecialException("Cannot delete from empty list");
        if (first.next == null) {
            first = null;
            last = null;
            return;
        }
        ListElement elem = first;
        while (elem.next.next != null) {
            elem = elem.next;
        }
        elem.next = null;
    }

    //удаление элемента
    void delete(T parameter) throws SpecialException {
        if (first == null)      //если список пустой
            throw new SpecialException("Cannot delete from empty list");
        //если нужный элемент первый в списке
        if (first.parameter == parameter) {
            first = first.next;
            return;
        }
        ListElement elem = first;
        while (elem.next != null) {
            if (elem.next.parameter == parameter) {
                if (last == elem.next) {        //если нужный элемент последний в списке
                    last = elem;
                }
                elem.next = elem.next.next;
                return;
            }
            elem = elem.next;
        }
    }

    // Возвращает значение элемента по номеру
    T get(int position) {
        ListElement elem = first;
        if (position == 0)
            return (T) elem.parameter;
        while (position > 0) {
            elem = elem.next;
            position--;
        }
        return (T) elem.parameter;
    }

    void set(int position, T parameter) {
        ListElement elem = first;
        if (position == 0)
            first.parameter = parameter;
        while (position > 0) {
            elem = elem.next;
            position--;
        }
        elem.parameter = parameter;
    }

    // Добавление єлемента по индексу
    void add(int position, T parameter) {

        ListElement newElem = new ListElement();
        newElem.parameter = parameter;
        ListElement elem = first;

        if (position == 0) {
            newElem.next = first;
            first = newElem;
        } else {

            while (position > 1) {
                elem = elem.next;
                position--;
            }
            newElem.next = elem.next;
            elem.next = newElem;
        }
    }

}


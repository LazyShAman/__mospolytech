# Требующийся функционал программы:
# 1. Создание массива случайных элементов заданного в интерфейсе размера.
# 2. Функции поиска, вставки и удаления по случайному массиву.
# 3. Создание упорядоченного массива заданного в интерфейсе размера.
# 4. Функции поиска, двоичного поиска, вставки и удаления из упорядоченного массива.

import PySimpleGUI as sg
import random
import time
from datetime import datetime

def is_int(input):
    try:
        int(input)
        return True
    except ValueError:
        return False


def bubble_sort(a):
    for i in range(len(a)-1, 1, -1):    # внешний цикл
        for j in range(0, i):           # внутренний цикл
            if a[j] > a[j+1]:
                temp = a[j+1]
                a[j+1] = a[j]
                a[j] = temp
    return a


def pretty_array(a):
    arr = ''
    for i in range(len(a)):
        arr += f"{str(a[i]):>8}"
        if (i+1) % 8 == 0:
            arr += '\n'
    return arr


def search(a, searchKey):
    for i in range(len(a)):
        if a[i] == searchKey:
            return i        # элемент найден
    return -1               # элемент не найден


def binary_search(a, searchKey):
    lowerBound = 0
    upperBound = len(a) - 1
    while (True):
        curIn = (lowerBound + upperBound) // 2
        if a[curIn] == searchKey:
            return curIn    # элемент найден
        elif lowerBound > upperBound:
            return -1       # элемент не найден
        else:               # деление диапазона
            if a[curIn] < searchKey:
                lowerBound = curIn + 1  # в верхней половине
            else:
                upperBound = curIn - 1  # в нижней половине


def auto_insert(a, insertKey):
    if insertKey < a[0]:
        a.insert(0, insertKey)

    for i in range(len(a)-1):
        if insertKey > a[i] and insertKey < a[i+1]:
            a.insert(i+1, insertKey)

    if insertKey > a[len(a)-1]:
        a.insert(len(a), insertKey)

    return a


# sg.theme_previewer()


sg.theme('BrightColors')
font = ('Consolas', 12)
font700 = ('Consolas', 12, 'bold')

layout = [
    [sg.Text('array length', font=font), sg.InputText(key='-LEN-', font=font)],
    [sg.Checkbox('sort the array', key='-SRT-', font=font)],
    [sg.Submit('submit', font=font), sg.Cancel('cancel', font=font)]
]
window = sg.Window('array length input', layout)
n = None

while n is None:
    event, values = window.read()
    if event == 'submit':
        if not is_int(values['-LEN-']):
            except_layout = [
                [sg.Text('array length must be integer', font=font)]
            ]
            except_window = sg.Window('ERROR', except_layout)
            except_event = except_window.read()

        if is_int(values['-LEN-']):
            n = int(values['-LEN-'])
            a = []

            for i in range(n):
                a.append(random.randint(0, 1000000))

    if event == 'cancel':
        window.close()
        break

window.close()

if n > 0:
    srt_func = []
    if values['-SRT-'] == True:
        a = bubble_sort(a)
        srt_func = [
            sg.Text('binsch', font=font), sg.InputText(key='-BIN-', font=font),
            sg.Button('go', key='-BIN_GEN-', font=font)
        ]

    arr = pretty_array(a)

    arr_layout = [
        [sg.Text(arr, justification='center', font=font700)],
        [sg.Text('search', font=font), sg.InputText(key='-SCH-', font=font),
            sg.Button('go', key='-SCH_GEN-', font=font)],
        srt_func,
        [sg.Text('insert', font=font), sg.InputText(key='-INS-', font=font),
            sg.Button('go', key='-INS_GEN-', font=font)],
        [sg.Text('delete', font=font), sg.InputText(key='-DEL-', font=font),
            sg.Button('go', key='-DEL_GEN-', font=font)],
        [sg.Cancel('cancel', font=font)]
    ]
    arr_window = sg.Window('menu', arr_layout)

    arr_event = ''
    while not arr_event == 'cancel':
        srt_func = [
            sg.Text('binsch', font=font), sg.InputText(key='-BIN-', font=font),
            sg.Button('go', key='-BIN_GEN-', font=font)
        ]
        arr_event, arr_values = arr_window.read()

        if arr_event == '-SCH_GEN-' and arr_values['-SCH-'] is not None:
            if not is_int(arr_values['-SCH-']):
                except_layout = [
                    [sg.Text('the sought-for number must be integer', font=font)]
                ]
                except_window = sg.Window('ERROR', except_layout)
                except_event = except_window.read()

            if is_int(arr_values['-SCH-']):
                time1 = datetime.now()

                searchFor = int(arr_values['-SCH-'])
                location = search(a, searchFor)
                arr = pretty_array(a)

                time2 = datetime.now()

                arr_layout = [
                    [sg.Text(arr, justification='center', font=font700)],
                    [sg.Text('search', font=font), sg.InputText(default_text=searchFor, key='-SCH-', font=font),
                        sg.Button('go', key='-SCH_GEN-', font=font), sg.Text('on ' + str(location) + ' position', font=font)],
                    srt_func,
                    [sg.Text('insert', font=font), sg.InputText(key='-INS-', font=font),
                        sg.Button('go', key='-INS_GEN-', font=font)],
                    [sg.Text('delete', font=font), sg.InputText(key='-DEL-', font=font),
                        sg.Button('go', key='-DEL_GEN-', font=font)],
                    [sg.Text(f"completed in  {(time2-time1).total_seconds()*1000}", font=font)],
                    [sg.Cancel('cancel', font=font)]
                ]

                arr_window.close()
                arr_window = sg.Window('menu', arr_layout)

        if arr_event == '-BIN_GEN-' and arr_values['-BIN-'] is not None:
            if not is_int(arr_values['-BIN-']):
                except_layout = [
                    [sg.Text('the sought-for number must be integer', font=font)]
                ]
                except_window = sg.Window('ERROR', except_layout)
                except_event = except_window.read()

            if is_int(arr_values['-BIN-']):
                time1 = datetime.now()

                searchFor = int(arr_values['-BIN-'])
                location = binary_search(a, searchFor)
                arr = pretty_array(a)
                srt_func = [
                    sg.Text('binsch', font=font), sg.InputText(
                        default_text=searchFor, key='-BIN-', font=font),
                    sg.Button('go', key='-BIN_GEN-', font=font), sg.Text('on ' +
                                                                         str(location) + ' position', font=font)
                ]

                time2 = datetime.now()

                arr_layout = [
                    [sg.Text(arr, justification='center', font=font700)],
                    [sg.Text('search', font=font), sg.InputText(key='-SCH-', font=font),
                        sg.Button('go', key='-SCH_GEN-', font=font)],
                    srt_func,
                    [sg.Text('insert', font=font), sg.InputText(key='-INS-', font=font),
                        sg.Button('go', key='-INS_GEN-', font=font)],
                    [sg.Text('delete', font=font), sg.InputText(key='-DEL-', font=font),
                        sg.Button('go', key='-DEL_GEN-', font=font)],
                    [sg.Text(f"completed in  {(time2-time1).total_seconds()*1000}", font=font)],
                    [sg.Cancel('cancel', font=font)]
                ]

                arr_window.close()
                arr_window = sg.Window('menu', arr_layout)

        if arr_event == '-INS_GEN-' and arr_values['-INS-'] is not None:
            if not is_int(arr_values['-INS-']):
                except_layout = [
                    [sg.Text('the inserted number must be integer', font=font)]
                ]
                except_window = sg.Window('ERROR', except_layout)
                except_event = except_window.read()

            if is_int(arr_values['-INS-']):
                time1 = datetime.now()

                toInsert = int(arr_values['-INS-'])
                if values['-SRT-']:
                    a = auto_insert(a, toInsert)
                else:
                    a.append(toInsert)
                arr = pretty_array(a)
                print(arr)

                time2 = datetime.now()

                arr_layout = [
                    [sg.Text(arr, justification='center', font=font700)],
                    [sg.Text('search', font=font), sg.InputText(key='-SCH-', font=font),
                        sg.Button('go', key='-SCH_GEN-', font=font)],
                    srt_func,
                    [sg.Text('insert', font=font), sg.InputText(default_text=toInsert, key='-INS-', font=font),
                        sg.Button('go', key='-INS_GEN-', font=font), sg.Text('success!', font=font)],
                    [sg.Text('delete', font=font), sg.InputText(key='-DEL-', font=font),
                        sg.Button('go', key='-DEL_GEN-', font=font)],
                    [sg.Text(f"completed in  {(time2-time1).total_seconds()*1000}", font=font)],
                    [sg.Cancel('cancel', font=font)]
                ]

                arr_window.close()
                arr_window = sg.Window('menu', arr_layout)

        if arr_event == '-DEL_GEN-' and arr_values['-DEL-'] is not None:
            if not is_int(arr_values['-DEL-']):
                except_layout = [
                    [sg.Text('the deleted number must be integer', font=font)]
                ]
                except_window = sg.Window('ERROR', except_layout)
                except_event = except_window.read()

            if is_int(arr_values['-DEL-']):
                time1 = datetime.now()

                toDelete = int(arr_values['-DEL-'])
                location = search(a, toDelete)
                if location == -1:
                    message = 'nothing'
                else:
                    a.remove(toDelete)
                    message = 'success!'
                arr = pretty_array(a)

                time2 = datetime.now()

                arr_layout = [
                    [sg.Text(arr, justification='center', font=font700)],
                    [sg.Text('search', font=font), sg.InputText(key='-SCH-', font=font),
                        sg.Button('go', key='-SCH_GEN-', font=font)],
                    srt_func,
                    [sg.Text('insert', font=font), sg.InputText(key='-INS-', font=font),
                        sg.Button('go', key='-INS_GEN-', font=font)],
                    [sg.Text('delete', font=font), sg.InputText(default_text=toDelete, key='-DEL-', font=font),
                        sg.Button('go', key='-DEL_GEN-', font=font), sg.Text(message, font=font)],
                    [sg.Text(f"completed in  {(time2-time1).total_seconds()*1000}", font=font)],
                    [sg.Cancel('cancel', font=font)]
                ]

                arr_window.close()
                arr_window = sg.Window('menu', arr_layout)

        if arr_event == 'cancel':
            arr_window.close()
            break

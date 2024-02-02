/**
 * @author Valens NIYONSENGA
 */

#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <cctype>
#include <algorithm>
#include <cstring>
using namespace std;

typedef vector<string> Vs;
typedef vector<int> Vi;

struct Item
{

    string item_id;
    string item_name;
    int item_quantity;
    string item_registration_date;
};

// procedure

/**
 *  1. Vector of commands
 *  2. 2 functions ( reading and writing to file)
 *  3.
 */

Vs commands;

void initializeCommands()
{
    commands.push_back("list");
    commands.push_back("add");
}

bool isFileOpen(ifstream file)
{
    return file.is_open();
}
void ListItems()
{
    ifstream file("list.txt");

    string line;

    if (!file.is_open())
    {
        cout << "Failed to open the file";
        return;
    }

    while (!file.eof())
    {
        getline(file, line);
        cout << line << "\n";
    }
}

void addItem()
{
    Item item;

    cout << "\nEnter Item Id :";
    getline(cin, item.item_id);
    cout << "\nEnter Item name : ";
    getline(cin, item.item_name);
    cout << "\nEnter Quantity : ";
    cin >> item.item_quantity;
    cin.ignore();
    cout << "\nEnter Item registration date .[format DD-MM-YY]. : ";
    getline(cin, item.item_registration_date);

    ofstream myfile;
    myfile.open("list.txt", ios::app);
    myfile << "\nItem ID:" < < < < item.item_id << setw(40) << " Item Name:" << item.item_name << setw(40) << " Quantity :" << item.item_quantity << setw(40) << " Reg Date :" << item.item_registration_date;
    myfile.close();
}

bool isFound(string str)
{
    auto it = find(commands.begin(), commands.end(), str);
    return it != commands.end();
}

int main()
{

    initializeCommands();
    bool go = true;
    string command;

    while (go == true)
    {

    start:
        cout << "\n> ";
        cin >> command;
        if (command.compare("exit") == 0)
        {
            go = false;
            return 1;
        }
        if (!isFound(command))
        {
            cout << "Invalid command";
            goto start;
        }

        if (command.compare("list") == 0)
        {
            ListItems();
            goto start;
        }
        else if (command.compare("add") == 0)
        {
            addItem();
            goto start;
        }
        else
        {
            cout << "\nInvalid command";
            return 1;
        }
    }

    return 1;
}
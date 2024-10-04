#include <iostream>
using namespace std;

struct Node {
    int value;
    Node* next;
};

struct LinkedListWithoutHead {
public:
    void addNode(Node** initial, int value) {
        Node* newNode = new Node(); // Usando `new` para alocar memória
        newNode->value = value;
        newNode->next = nullptr;

        if (*initial == nullptr) {
            *initial = newNode; // Atribuindo corretamente o novo nó ao início da lista
            return;
        }

        Node* current = *initial; // Corrigido para obter o nó inicial
        while (current->next != nullptr) {
            current = current->next; // Avançando para o próximo nó
        }
        current->next = newNode; // Adicionando o novo nó ao final da lista
    }

    void printList(Node* initial) { // Método para imprimir a lista
        if (initial == nullptr) {
            cout << "Lista vazia" << endl;
            return;
        }

        Node* current = initial;
        while (current != nullptr) {
            cout << current->value << " "; // Imprimindo o valor do nó atual
            current = current->next; // Avançando para o próximo nó
        }
        cout << endl; // Quebra de linha após a impressão da lista
    }
};

int main() {
    LinkedListWithoutHead lst;

    Node* initial = nullptr; // Inicializando a lista como vazia
    lst.addNode(&initial, 2);
    lst.addNode(&initial, 3);
    lst.addNode(&initial, 4);

    lst.printList(initial); // Exibindo a lista

    return 0;
}

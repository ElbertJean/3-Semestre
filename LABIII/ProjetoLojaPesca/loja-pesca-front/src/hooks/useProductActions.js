import { useState, useCallback } from 'react';

const useProductActions = () => {
    const [shouldFetchData, setShouldFetchData] = useState(true);

    const GetItems = useCallback(async (setData) => {
        try {
            const response = await fetch('http://localhost:8080/loja-pesca', {
                method: 'GET',
                headers: {
                'Content-Type': 'application/json',
                },
            });
            
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }

            const result = await response.json();
            setData(result);
            setShouldFetchData(false);
        } catch (error) {
            console.log('error', error);
        }
    }, []);

    const PostItem = async (
        e, 
        idValue, 
        lineMarkValue, 
        mmLineValue, 
        idRandom, 
        setData, 
        setShouldFetchData, 
        setIdValue, 
        setLineMarkValue, 
        setMmLineValue
        ) => {
        e.preventDefault();
        try {
            const response = await fetch('http://localhost:8080/loja-pesca', {
                method: 'POST',
                body: JSON.stringify({
                id: idValue + idRandom,
                lineMark: lineMarkValue,
                mmLine: mmLineValue
                }),
                headers: {
                    'Content-Type': 'application/json',
                }}
            );
        
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }

            alert('Item Cadastrado com sucesso!');
            setShouldFetchData(true);
            setIdValue("");
            setLineMarkValue("");
            setMmLineValue("");
        } catch (error) {
            alert('Erro ao cadastrar!');
        }
    };

    const EditItem = async (item, setSelectedItem, setShowModal) => {
        try {
            const response = await fetch(`http://localhost:8080/loja-pesca/${item.id}`, {
                method: 'GET',
                headers: {
                'Content-Type': 'application/json',
                },
            });

            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }

            const result = await response.json();
            setSelectedItem(result);
            setShowModal(true);
        } catch (error) {
            console.log('error', error);
        }
    };

    const DeleteItem = async (id, setShouldFetchData) => {
        try {
            const response = await fetch(`http://localhost:8080/loja-pesca/${id}`, {
                method: 'DELETE',
                headers: {
                'Content-Type': 'application/json',
                }}
            );
            
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }

            alert('Item excluído com sucesso!');
            setShouldFetchData(true); 
        } catch (error) {
            alert('Erro ao excluir!');
        }
    };

  return { GetItems, PostItem, EditItem, DeleteItem, shouldFetchData, setShouldFetchData };
};

export default useProductActions;

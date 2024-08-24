import React, { useEffect, useState, useCallback } from 'react';
import NavBar from '../../components/NavBar/NavBar.component';
import styles from './Products.module.css';
import { FaTrash } from "react-icons/fa";
import { MdEdit } from "react-icons/md";
import Modal from '../../components/Modal/Modal.component';
import Music from '../../components/Music/Music.component';
import useProductActions from '../../hooks/useProductActions';
import Layout from '../../components/Layout/Layout.component';


function Products() {
    const [data, setData] = useState([]);

    const [selectedItem, setSelectedItem] = useState(null);
    const [showModal, setShowModal] = useState(false);

    const { 
        EditItem, 
        DeleteItem, 
        GetItems, 
        shouldFetchData, 
        setShouldFetchData
    } = useProductActions();

    const fetchItems = useCallback(() => {
        GetItems(setData);
    }, [GetItems]);

    useEffect(() => {
        if (!shouldFetchData) return;
        fetchItems();
    }, [shouldFetchData, fetchItems]);

    const handleEdit = (item) => {
        EditItem(
            item, 
            setSelectedItem, 
            setShowModal
        );
    };

    const handleDelete = (id) => {
        DeleteItem(id, setShouldFetchData);
    };

    return (
        <Layout>
            <section id='Produtos'>
                <h2 className={styles.h2}>Produtos</h2>
                <div className={styles.divItems}>
                    {data.length > 0 ? data.map((item) => (
                    <div key={`${item.id}-${Math.random()}`} className={styles.cardItems}>
                        <h3 className={styles.h3Card}>{item.lineMark}</h3>
                        <p className={styles.paragraphCard}>{item.mmLine}</p>
                        <MdEdit className={styles.iconeEdit} onClick={() => handleEdit(item)}/>
                        <FaTrash className={styles.iconTrash} onClick={() => handleDelete(item.id)}/>
                    </div>
                    )): (
                    <>
                        <p>Não há produtos cadastrados no momento</p>
                    </>
                    )}
                </div>
            </section>
            {showModal ? (
                <div className={`${styles.cardMapExpanded}`}>
                    <Modal 
                        item={selectedItem} 
                        closeModal={() => setShowModal(false)} 
                        setShowModal={setShowModal}
                        setShouldFetchData={setShouldFetchData}
                    />
                </div>
            ): (
                <div className={`${styles.cardMapCollapsed}`}>
                    <Modal />
                </div>
            )}
        </Layout>
    );
}

export default Products;

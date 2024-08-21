import React, {useState, useEffect} from 'react';
import styles from './Modal.module.css';
import { IoCloseSharp } from "react-icons/io5";

const Modal = ({ closeModal, item, setShowModal, setShouldFetchData }) => {
    
    const [idValue, setIdValue] = useState("");
    const [lineMarkValue, setLineMarkValue] = useState("");
    const [mmLineValue, setMmLineValue] = useState("");

    const [disabledButton, setDisabledButton] = useState(true);
    console.log('disabledButton', disabledButton);

    
    useEffect(() => {
        if (item) {
            setIdValue(item.id);
            setLineMarkValue(item.lineMark);
            setMmLineValue(item.mmLine);
        }
    }, [item]);
    
    useEffect(() => {
        if (lineMarkValue.length > 0 && mmLineValue.length > 0) {
            setDisabledButton(false);
        } else {
            setDisabledButton(true);
        }
    }, [lineMarkValue, mmLineValue]);

    const PutItem = async (e) =>  {
        e.preventDefault();
        try {
            const response = await fetch(`http://localhost:8080/loja-pesca/${idValue}`, {
                method: 'PUT',
                body: JSON.stringify({
                    id: idValue,
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

            if (response.ok) {
                alert('Item editado com sucesso!');
                setShowModal(false);
                setShouldFetchData(true);
            }
        } catch (error) {
            alert('Erro ao cadastrar!');
        }
    }
    
    return (
        <div className={styles.modal}>
            <IoCloseSharp className={styles.iconClose} onClick={closeModal} />
            <h3 className={styles.h3}>Editar produto</h3>
            <form className={styles.form}>
                <div className={styles.divForm}>
                    <p className={styles.labelInputForm}> ID do produto:</p>
                    <input 
                        type="text" 
                        value={idValue}
                        className={styles.inputForm}
                        readOnly
                        disabled
                    />
                </div>
                <div className={styles.divForm}>
                    <p className={styles.labelInputForm}> Marca da linha:</p>
                    <input 
                        type="text" 
                        value={lineMarkValue}
                        className={styles.inputForm}
                        onChange={(e) => setLineMarkValue(e.target.value)}
                    />
                </div>
                <div className={styles.divForm}>
                    <p className={styles.labelInputForm}> mm Linha: </p>
                    <input 
                        type="text" 
                        value={mmLineValue}
                        className={styles.inputForm}
                        onChange={(e) => setMmLineValue(e.target.value)}
                    />
                </div>
                <button 
                    type="submit" 
                    className={`${styles.button} ${disabledButton ? styles.buttonDisabled : styles.buttonAdd}`}
                    onClick={PutItem}
                    disabled={disabledButton}
                >
                    Atualizar
                </button>
            </form>
        </div>
    );
};

export default Modal;

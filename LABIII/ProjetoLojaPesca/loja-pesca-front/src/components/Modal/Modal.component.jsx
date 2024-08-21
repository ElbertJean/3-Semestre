import React, { forwardRef } from 'react';
import styles from './Modal.module.css';

const Modal = forwardRef((props, teste) => {
    const close = () => {
        teste?.current?.close();
    };

    return (
        <div ref={teste} className={styles.modal}>
            <div>
                <p>Apenas um teste</p>
                <button onClick={close}>Fechar</button>
            </div>
        </div>
    );
});

export default Modal;

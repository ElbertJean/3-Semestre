import React from 'react';
import styles from './InputText.module.css';

function InputText({placeholder, onChange, className, value, readOnly, disabled}) {
    return(
        <input 
            type="text" 
            placeholder={placeholder} 
            onChange={onChange}
            className={`${styles.input} ${className}`}
            value={value}
            readOnly={readOnly}
            disabled={disabled}
        />
    )
}

export default InputText
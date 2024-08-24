import React from 'react';
import styles from './Button.module.css'

function Button ({type, className, onClick, disabled, title}) {
    return(
        <button 
            type={type}
            className={`${styles.button} ${className}`}
            onClick={onClick}
            disabled={disabled}
        >
            {title}
        </button>
    )   
}

export default Button;
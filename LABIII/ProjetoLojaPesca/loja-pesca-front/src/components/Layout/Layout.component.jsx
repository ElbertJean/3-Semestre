import React from 'react'
import styles from './Layout.module.css'

import NavBar from '../NavBar/NavBar.component';
import WhatsApp from '../WhatsApp/WhatsApp.component';

function Layout({ children }) {
    return (
        <div className={styles.container}>
            <NavBar />
            <div className={styles.content}>
                {children}
            </div>
            <WhatsApp />
        </div>
    )
}

export default Layout;
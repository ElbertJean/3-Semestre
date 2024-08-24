import React from 'react'
import styles from './Layout.module.css'

import NavBar from '../NavBar/NavBar.component';
import Music from '../Music/Music.component';

function Layout({ children }) {
    return (
        <div className={styles.container}>
            <NavBar />
            <div className={styles.content}>
                {children}
            </div>
            <Music />
        </div>
    )
}

export default Layout;
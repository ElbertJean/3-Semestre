import React, {  useState, useRef} from 'react';
import styles from './Music.module.css';

import AgroPescaJacare from './assets/AgroPescaJacare.mp3';

import { FaPlay, FaPause } from "react-icons/fa";

function Music() {
    
    const audioRef = useRef(null);
    const [isPlaying, setIsPlaying] = useState(false);

    const togglePlay = () => {
        if (isPlaying) {
            audioRef.current.pause();
        } else {
            audioRef.current.play();
        }
        setIsPlaying(!isPlaying);
    };
    
    return(
        <div className={styles.musicPlayer}>
            <button 
                className={`${styles.playButton} ${isPlaying ? styles.pauseButton : ''}`}
                onClick={togglePlay}
            >
                {isPlaying ? <FaPause/> : <FaPlay/>}
            </button>
            <audio ref={audioRef} src={AgroPescaJacare} />
        </div>
    )
}

export default Music;
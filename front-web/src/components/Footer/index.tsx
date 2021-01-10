import './styles.css';

import { ReactComponent as YoutubeIcon } from '../../assets/youtube.svg';
import { ReactComponent as InstagramIcon } from '../../assets/instagram.svg';
import { ReactComponent as LinkedinIcon } from '../../assets/linkedin.svg';

function Footer(){
    return(
        <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            <div className="footer-icons">
                <a href="youtube" target="_new">
                    <YoutubeIcon />
                </a>
                <a href="instagram" target="_new">
                    <InstagramIcon />
                </a>
                <a href="linkedin" target="_new">
                    <LinkedinIcon />
                </a>
            </div>
        </footer>
    )
}

export default Footer;
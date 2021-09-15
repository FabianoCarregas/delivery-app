import './styles.css';
import { ReactComponent as LinkedinIcon } from './linkedin.svg'; 
import { ReactComponent as GithubIcon } from './github.svg';

function Footer(){
    return (
        <footer className="main-footer">
            App Delivery, desenvolvido por Fabiano Carregas
            <div className="footer-icons">
                <a href="https://www.linkedin.com/in/fabiano-carregas/" target="_new">
                    <LinkedinIcon />
                </a>
                <a href="https://github.com/FabianoCarregas" target="_new" >
                    <GithubIcon />
                </a>

            </div>

        </footer>
    )
}

export default Footer;
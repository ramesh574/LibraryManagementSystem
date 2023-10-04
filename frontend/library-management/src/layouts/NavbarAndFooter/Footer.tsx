export const Footer=()=>{
    return(
        <div className='bg-tone'>
        <footer className='container d-flex flex-wrap 
            justify-content-between align-items-center py-4 bg-tone'>
            <p className='col-md-4 mb-0 text-block'>© Library App, Inc</p>
            <ul className='nav navbar-light col-md-4 justify-content-end'>
                <li className='nav-item'>
                    <a className='nav-link px-2 text-black'>
                        Home
                    </a>
                </li>
                <li className='nav-item'>
                    <a className='nav-link px-2 text-black'>
                        Search Books
                    </a>
                </li>
            </ul>
        </footer>
    </div>
    );
}
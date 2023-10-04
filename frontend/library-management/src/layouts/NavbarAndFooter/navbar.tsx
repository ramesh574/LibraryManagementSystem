import { Link, NavLink } from "react-router-dom";
import { SpinnerLoading } from "../Utils/SpinnerLoading";
import { useOktaAuth } from "@okta/okta-react";

export const Navbar=()=>{
  const { oktaAuth, authState } = useOktaAuth();

  if (!authState) {
    return <SpinnerLoading />
  }

  const handleLogout = async () => oktaAuth.signOut();

  console.log(authState);
    return (
        <nav className='navbar navbar-expand-lg navbar-light bg-tone'>
      <div className='container-fluid'>
        <span className='navbar-brand'>LibraryWorld</span>
        <button className='navbar-toggler' type='button'
          data-bs-toggle='collapse' data-bs-target='#navbarNavDropdown'
          aria-controls='navbarNavDropdown' aria-expanded='false'
          aria-label='Toggle Navigation'
        >
          <span className='navbar-toggler-icon'></span>
        </button>
        <div className='collapse navbar-collapse' id='navbarNavDropdown'>
          <ul className='navbar-nav ms-auto text-uppercase'>
            <li className='nav-item active'>
              <NavLink className='nav-link text-black' to='/home'>Home</NavLink>
            </li>
            <li className='nav-item'>
              <a className='nav-link text-black' href='/about'>About</a>
            </li>
            <ul className='navbar-nav ms-auto'>
            {!authState.isAuthenticated ?
              <li className='nav-item'>
                <Link type='button' className='btn bg-tone' to='/login'>LOGIN</Link>
              </li>
              :
              <li>
                <button className='btn bg-tone ' onClick={handleLogout}>LOGOUT</button>
              </li>
            }
          </ul>
            <li className='nav-item'>
              < NavLink className='nav-link text-black' to='/search'>Search Books</NavLink>
            </li>
            {/* <li className='nav-item m-1'>
                <a type='button' className='btn btn-outline-light' href='/login'>Sign in</a>
              </li> */}
              </ul>
        </div>
      </div>
    </nav>
    );
}
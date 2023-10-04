import React from 'react';
import BookModel from '../../../models/BookModel';
import { Link } from 'react-router-dom';
export const ReturnBook: React.FC<{book: BookModel}> = (props) => {
    return(
        <div className='col-xs-6 col-sm-6 col-md-3 col-lg-3 mb-3'>
        <div className='text-center'>
        {props.book.img ? 
                    <img
                        src={props.book.img}
                        width='151'
                        height='233'
                        alt="book"
                    />
                    :
                    <img
                        src={require('./../../../Images/BooksImages/book-luv2code-1000.png')}
                        width='151'
                        height='233'
                        alt="book"
                    />
                }
          <h6 className='mt-2'>Book</h6>
          <p>Library Management</p>
          <Link type='button' className='btn bg-tone btn-lg text-block' to={`checkout/${props.book.id}`}>
            Reserve
          </Link>
        </div>
      </div>
    );
 }
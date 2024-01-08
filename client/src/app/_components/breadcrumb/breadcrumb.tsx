import Link from 'next/link';
import React from 'react';

const Breadcrumb = () => {
  return (
<nav className="flex px-2 py-2 text-gray-100 border border-gray-200 rounded-lg bg-purple-700 text-md" aria-label="Breadcrumb">
  <ol className="inline-flex items-center space-x-1 md:space-x-2 rtl:space-x-reverse">
    <li className="inline-flex items-center">
      <Link href="#" className="inline-flex items-center font-medium text-gray-100 hover:text-blue-600 ">
        Home
      </Link>
    </li>
    <li>
      <div className="flex items-center">
        
        <svg className="rtl:rotate-180 block w-3 h-3 mx-1 text-gray-400 " aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 6 10">
          <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m1 9 4-4-4-4"/>
        </svg>
        <Link href="#" className="ms-1 font-medium hover:text-blue-600 md:ms-2 text-white">Whatever</Link>
      </div>
    </li>
  </ol>
</nav>
  )
}

export default Breadcrumb
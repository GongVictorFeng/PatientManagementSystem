import React from 'react'
import PatientRegister from '../../_components/register/registerPatient/registerPatient'

const page = ({params}) => {
  return (

    <div className='min-h-screen bg-gradient-to-tr from-secondary to-blue-100 flex items-center justify-center rounded-xl'>
    <PatientRegister empId={params.empId}/>


    </div>
  )
}

export default page
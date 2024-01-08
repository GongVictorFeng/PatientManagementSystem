'use client';
import React from 'react'
import Profile from '@/app/_components/profile/staffProfile';
import { getUser } from '@/app/_lib/user';

const profile = () => {

  return (
    

    <div className="min-h-screen bg-gray-100">
      <Profile user={getUser(localStorage)}/>
      </div>
  )
}

export default profile